package com.Handson.warehouseManagement.serviceInterface;

import com.Handson.warehouseManagement.entity.Order;
import com.Handson.warehouseManagement.entity.Shipment;

public interface ShipmentService {

    //create a shipment for an order
    Shipment createShipment(Order order);

    //get shipment details by id
    Shipment getShipmentById(Long id);

    //dispatch the shipment to the customer
    void dispatchShipment(Long shipmentId);
}
