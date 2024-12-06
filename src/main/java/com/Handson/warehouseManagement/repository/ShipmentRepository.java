package com.Handson.warehouseManagement.repository;

import com.Handson.warehouseManagement.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
