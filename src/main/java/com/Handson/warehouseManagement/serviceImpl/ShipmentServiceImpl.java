package com.Handson.warehouseManagement.serviceImpl;

import com.Handson.warehouseManagement.entity.Order;
import com.Handson.warehouseManagement.entity.Shipment;
import com.Handson.warehouseManagement.repository.ShipmentRepository;
import com.Handson.warehouseManagement.serviceInterface.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public Shipment createShipment(Order order){

        Shipment shipment = new Shipment();
        shipment.setOrder(order);
        shipment.setShipmentDate(LocalDateTime.now());
        shipment.setStatus("Pending");
        return shipmentRepository.save(shipment);

    }

    @Override
    public Shipment getShipmentById(Long id){

        return shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment id " + id + " not found"));

    }

    @Override
    public void dispatchShipment(Long shipmentId){

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new RuntimeException("shipment id "+shipmentId+ " not found.."));
        shipment.setStatus("Dispatched");
        shipment.setDispatchDate(LocalDateTime.now());
        shipmentRepository.save(shipment);
    }

}
