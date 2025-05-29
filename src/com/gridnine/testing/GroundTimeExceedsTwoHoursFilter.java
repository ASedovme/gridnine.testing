package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class GroundTimeExceedsTwoHoursFilter implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    for (int i = 0; i < segments.size() - 1; i++) {
                        Segment current = segments.get(i);
                        Segment next = segments.get(i + 1);
                        long groundMinutes = java.time.Duration.between(current.getArrivalDate(), next.getDepartureDate()).toMinutes();
                        if (groundMinutes > 120) { // более двух часов
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }
}