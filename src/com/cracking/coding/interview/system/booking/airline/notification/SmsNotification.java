package com.cracking.coding.interview.system.booking.airline.notification;

public class SmsNotification extends Notification {
    private String mobileNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean send() {
        return false;
    }
}
