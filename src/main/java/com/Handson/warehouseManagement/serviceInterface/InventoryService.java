package com.Handson.warehouseManagement.serviceInterface;

import com.Handson.warehouseManagement.entity.Product;

import java.util.Optional;

public interface InventoryService {

    //check availability of a product by product id
    boolean isProductAvailable(Long productId, int quantity);

    //update product quantity after an order is placed or items are shipped
    void updateProductQuantity(Long productId, int quantity);

    //retrieve the product details by id
    Optional<Product> getProductById(Long id);


}
