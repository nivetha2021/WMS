package com.Handson.warehouseManagement.repository;

import com.Handson.warehouseManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
