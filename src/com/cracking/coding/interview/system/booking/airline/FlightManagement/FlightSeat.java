package com.cracking.coding.interview.system.booking.airline.FlightManagement;

public class FlightSeat extends Seat{
    private int fare;
    private BookingStatus bookingStatus;

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
