package com.Handson.warehouseManagement.serviceImpl;

import com.Handson.warehouseManagement.entity.Product;
import com.Handson.warehouseManagement.repository.ProductRepository;
import com.Handson.warehouseManagement.serviceInterface.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final ProductRepository productRepository;

    @Autowired
    public InventoryServiceImpl (ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public boolean isProductAvailable(Long productId, int quantity){

        //check if the product exist and has suficient quantity
        return productRepository.findById(productId)
                .map(product -> product.getQuantityInStock() >= quantity)
                .orElse(false);


    }

    @Override
   public void updateProductQuantity(Long productId, int quantity){

        //find the product by id
       Product product = productRepository.findById(productId)
               .orElseThrow(()->new RuntimeException("product not found with given id  "+productId));
       //update the product's quantity
       int updatedQuantity = product.getQuantityInStock() - quantity;
       if (updatedQuantity < 0){
           throw new IllegalArgumentException("Insufficient stock for product id  "+productId);
       }
       product.setQuantityInStock(updatedQuantity);
       productRepository.save(product);

    }

    @Override
    public Optional<Product> getProductById(Long id){

        return productRepository.findById(id);

    }

}
