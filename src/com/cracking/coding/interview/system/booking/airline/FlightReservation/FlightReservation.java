package com.cracking.coding.interview.system.booking.airline.FlightReservation;

import com.cracking.coding.interview.system.booking.airline.FlightManagement.FlightSchedule;
import com.cracking.coding.interview.system.booking.airline.FlightManagement.FlightSeat;

import java.util.Date;
import java.util.Map;

public class FlightReservation {
    private String reservationNumber;
    private FlightSchedule flightSchedule;
    private Map<Customer, FlightSeat> seatMap;
    private Date creationDate;
    private ReservationStatus status;

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(FlightSchedule flightSchedule) {
        this.flightSchedule = flightSchedule;
    }

    public Map<Customer, FlightSeat> getSeatMap() {
        return seatMap;
    }

    public void setSeatMap(Map<Customer, FlightSeat> seatMap) {
        this.seatMap = seatMap;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
