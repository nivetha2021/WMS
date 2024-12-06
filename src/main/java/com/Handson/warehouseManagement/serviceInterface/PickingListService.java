package com.Handson.warehouseManagement.serviceInterface;

import com.Handson.warehouseManagement.entity.Order;
import com.Handson.warehouseManagement.entity.PickingList;
import com.Handson.warehouseManagement.repository.PickingListRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface PickingListService {


    //create a picking list for a specific order
    PickingList createPickingList(Order order);

    //get picking list details by id
    PickingList getPickingListById(Long id);

    //mark items as picked
    void markedItemAsPicked(Long pickingListId);

}
