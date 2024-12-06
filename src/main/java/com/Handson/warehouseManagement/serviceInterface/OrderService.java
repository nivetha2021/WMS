package com.Handson.warehouseManagement.serviceInterface;

import com.Handson.warehouseManagement.entity.Order;


public interface OrderService {

    //place an order and reserve item
    Order placeOrder(Order order);

    //get order details by id
    Order getOrderById(Long id);

    //update the status of an order
    Order updateOrderStatus(Long orderId, String status);
}
