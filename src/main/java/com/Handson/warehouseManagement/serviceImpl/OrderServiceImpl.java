package com.Handson.warehouseManagement.serviceImpl;

import com.Handson.warehouseManagement.entity.Order;
import com.Handson.warehouseManagement.entity.OrderItem;
import com.Handson.warehouseManagement.repository.OrderRepository;
import com.Handson.warehouseManagement.serviceInterface.InventoryService;
import com.Handson.warehouseManagement.serviceInterface.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order placeOrder(Order order){

        //check if all products are available
        for(OrderItem item:order.getOrderItems()){

            if(!inventoryService.isProductAvailable(item.getProduct().getId(), item.getQuantity())){
                throw new IllegalArgumentException("product with id " +item.getProduct().getId()+"is not available in the required quantity");
            }
        }
        //reserve items in inventory
        for(OrderItem item: order.getOrderItems()){

            inventoryService.updateProductQuantity(item.getProduct().getId(), -item.getQuantity());
        }

        //save the order & its item
        order.setStatus("placed");
        return orderRepository.save(order);

    }
    @Override
    public Order getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }

    @Override
    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("order not found with ID: "+orderId));
        order.setStatus(status);
        return orderRepository.save(order);
    }

}
