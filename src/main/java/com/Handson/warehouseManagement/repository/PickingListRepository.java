package com.Handson.warehouseManagement.repository;

import com.Handson.warehouseManagement.entity.PickingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickingListRepository extends JpaRepository<PickingList, Long> {
}
