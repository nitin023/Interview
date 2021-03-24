package com.cracking.coding.interview.system.booking.airline.notification;

public class EmailNotification extends Notification{

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean send() {
        return false;
    }
}
