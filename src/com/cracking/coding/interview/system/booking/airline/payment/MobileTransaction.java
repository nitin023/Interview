package com.cracking.coding.interview.system.booking.airline.payment;

import java.util.Date;

public class MobileTransaction implements PaymentMethod{
    private String serviceProvider;
    private int mobileNumber;
    private Date expiryDate;

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean pay(double amount) {
        return false;
    }
}
