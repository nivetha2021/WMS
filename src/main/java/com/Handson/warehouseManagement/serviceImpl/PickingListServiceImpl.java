package com.Handson.warehouseManagement.serviceImpl;

import com.Handson.warehouseManagement.entity.Order;
import com.Handson.warehouseManagement.entity.PickingList;
import com.Handson.warehouseManagement.entity.Product;
import com.Handson.warehouseManagement.repository.PickingListRepository;
import com.Handson.warehouseManagement.repository.ProductRepository;
import com.Handson.warehouseManagement.serviceInterface.PickingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PickingListServiceImpl implements PickingListService {

    private final PickingListRepository pickingListRepository;
    private final ProductRepository productRepository;

    @Autowired
    public PickingListServiceImpl(PickingListRepository pickingListRepository, ProductRepository productRepository) {
        this.pickingListRepository = pickingListRepository;
        this.productRepository = productRepository;
    }

    @Override
    public PickingList createPickingList(Order order) {
        PickingList pickingList = new PickingList();
        pickingList.setOrderId(order.getId());
        pickingList.setStatus("Pending");

        List<PickingList.PickingItem> pickingItems = order.getOrderItems()
                .stream()
                .map(orderItem -> {
                    Product product = productRepository.findById(orderItem.getProduct().getId())
                            .orElseThrow(() -> new RuntimeException("Product not found with ID: " + orderItem.getProduct().getId()));
                    PickingList.PickingItem pickingItem = new PickingList.PickingItem();
                    pickingItem.setProductId(product.getId());
                    pickingItem.setProductName(product.getProductName());
                    pickingItem.setQuantity(orderItem.getQuantity());
                    return pickingItem;
                })
                .collect(Collectors.toList());

        pickingList.setPickingItem(pickingItems);
        return pickingListRepository.save(pickingList);
    }

    @Override
    public PickingList getPickingListById(Long id) {
        return pickingListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Picking List not found with ID: " + id));
    }
    @Override
    public void markedItemAsPicked(Long pickingListId) {
        PickingList pickingList = pickingListRepository.findById(pickingListId)
                .orElseThrow(() -> new RuntimeException("Picking List not found with ID: " + pickingListId));

        pickingList.setStatus("Completed");
        //picking list save
        pickingListRepository.save(pickingList);
    }
}