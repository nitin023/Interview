package com.cracking.coding.interview.system.booking.airline.payment;

import java.util.Date;

public class Paypal implements PaymentMethod{
    private String name;
    private String cardNumber;
    private Date expiryDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
