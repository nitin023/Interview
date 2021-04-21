package com.cracking.coding.interview.system.bookMyShow;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Movie {
    String movieId;
    String movieName;
    int durationInMin;
    String language;
    Genre genre;
    Date releaseDate;
    Map<String, List<Show>> cityShowMap;
}
