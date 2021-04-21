package com.cracking.coding.interview.system.parkingLot;

import java.util.Date;

public class ParkingTicket {
    int ticketId;
    int levelId;
    int spaceId;
    Date vehicleEntryDateTime;
    Date vehicleExitDateTime;
    ParkingSpaceType parkingSpaceType;
    double totalCost;
    ParkingTicketStatus parkingTicketStatus;

    public void updateTotalCost() { }

    public void updateVehicleExistTime(Date vehicleExitDateTime){ }
}
