package com.cracking.coding.interview.system.booking.airline.FlightManagement;

import java.util.Date;
import java.util.List;

public class FlightSchedule {

    Flight flight;
    private Date departureTime;
    private String gate;
    private FlightStatus status;
    private List<FlightSeat>flightSeats;

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public List<FlightSeat> getFlightSeats() {
        return flightSeats;
    }

    public void setFlightSeats(List<FlightSeat> flightSeats) {
        this.flightSeats = flightSeats;
    }
}
