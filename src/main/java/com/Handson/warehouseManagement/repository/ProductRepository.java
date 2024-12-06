package com.Handson.warehouseManagement.repository;

import com.Handson.warehouseManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
