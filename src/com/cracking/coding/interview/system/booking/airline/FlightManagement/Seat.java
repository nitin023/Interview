package com.cracking.coding.interview.system.booking.airline.FlightManagement;

public class Seat {

    private String seatNumber;
    private SeatClass sclass;

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatClass getSclass() {
        return sclass;
    }

    public void setSclass(SeatClass sclass) {
        this.sclass = sclass;
    }
}
