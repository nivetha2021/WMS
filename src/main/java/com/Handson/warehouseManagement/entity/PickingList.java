package com.Handson.warehouseManagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PickingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long orderId;
    private long productId;
    private int quantity;
    private String status;
    @ElementCollection
    private List<PickingItem> pickingItem;

    public static class PickingItem{

        private long productId;
        private String productName;
        private int quantity;

        public long getProductId() {
            return productId;
        }

        public void setProductId(long productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PickingItem> getPickingItem() {
        return pickingItem;
    }

    public void setPickingItem(List<PickingItem> pickingItem) {
        this.pickingItem = pickingItem;
    }



    @Override
    public String toString() {
        return "PickingList{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", pickingItem=" + pickingItem +
                '}';
    }
}
