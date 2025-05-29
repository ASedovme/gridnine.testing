package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class SegmentsWithInvalidDatesFilter implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    for (Segment segment : flight.getSegments()) {
                        if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }
}