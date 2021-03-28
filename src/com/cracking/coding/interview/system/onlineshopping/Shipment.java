package com.cracking.coding.interview.system.onlineshopping;

import java.util.Date;

public class Shipment {
    private String shipmentNumber;
    private Date shipmentDate;
    private Date estimatedArrivalDate;
    private String shipmentMethod;
    private Order orderDetails;

    public String getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(String shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public Date getEstimatedArrivalDate() {
        return estimatedArrivalDate;
    }

    public void setEstimatedArrivalDate(Date estimatedArrivalDate) {
        this.estimatedArrivalDate = estimatedArrivalDate;
    }

    public String getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(String shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public Order getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Order orderDetails) {
        this.orderDetails = orderDetails;
    }
}
