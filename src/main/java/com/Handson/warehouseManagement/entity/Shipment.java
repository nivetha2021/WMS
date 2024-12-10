package com.Handson.warehouseManagement.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //order table: each order is placed by a customer, but a customer can place many orders
    //customer table: a customer can have many orders, but each order belongs to only one customer
    //many:order, one:customer & vice versa
    @ManyToOne    //relationship btw 2 tables
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    private LocalDateTime shipmentDate;
    private LocalDateTime dispatchDate;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LocalDateTime getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(LocalDateTime shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public LocalDateTime getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(LocalDateTime dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", order=" + order +
                ", shipmentDate=" + shipmentDate +
                ", dispatchDate=" + dispatchDate +
                ", status='" + status + '\'' +
                '}';
    }
}
