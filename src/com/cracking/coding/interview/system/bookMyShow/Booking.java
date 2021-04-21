package com.cracking.coding.interview.system.bookMyShow;

import com.cracking.coding.interview.system.bookMyShow.BookingStatus;

import java.util.Date;
import java.util.List;

public class Booking {
    int bookingId;
    Date bookingDate;
    Member member;
    Show show;
    Audi audi;
    BookingStatus bookingStatus;
    double totalAmount;
    List<Seat> seatList;
    Payment payment;

    public boolean makePayment(Payment payment){
        return true;
    }

}
