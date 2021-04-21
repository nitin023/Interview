package com.cracking.coding.interview.system.parkingLot;

public class ParkingAttendant extends Account{
    Payment paymentService;
    public boolean processVehicleEntry(Vehicle vehicle){
        return true;
    }
    public boolean processPayment(ParkingTicket parkingTicket,PaymentType paymentType){
        return true;
    }
}
