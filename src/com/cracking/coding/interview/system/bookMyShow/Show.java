package com.cracking.coding.interview.system.bookMyShow;

import java.util.Date;
import java.util.List;

public class Show {
    int showId;
    Movie movie;
    Date startTime;
    Date endTime;
    CinemaHall cinemaHallPlayedAt;
    List<Seat> seats;
}
