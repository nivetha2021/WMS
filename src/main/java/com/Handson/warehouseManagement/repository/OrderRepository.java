package com.Handson.warehouseManagement.repository;

import com.Handson.warehouseManagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
