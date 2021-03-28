package com.cracking.coding.interview.system.onlineshopping;

import com.cracking.coding.interview.system.booking.airline.payment.PaymentMethod;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderNumber;
    private OrderStatus orderStatus;
    private Date orderDate;
    private List<OrderLog> orderLogList;

    public boolean sendForShipment(){
        return true;
    }
    public boolean makePayment(PaymentMethod paymentMethod){
        return true;
    }
    public boolean addOrderLog(OrderLog orderLog){
        return true;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderLog> getOrderLogList() {
        return orderLogList;
    }

    public void setOrderLogList(List<OrderLog> orderLogList) {
        this.orderLogList = orderLogList;
    }
}
