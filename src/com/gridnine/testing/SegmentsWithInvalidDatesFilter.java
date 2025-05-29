package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр, который исключает рейсы с сегментами, у которых дата прибытия раньше даты отправления.
 */
public class SegmentsWithInvalidDatesFilter implements FlightFilter {

    /**
     * Фильтрует список рейсов, исключая те, у которых есть сегменты с некорректными датами.
     *
     * @param flights список рейсов для фильтрации
     * @return список рейсов без сегментов с некорректными датами
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    for (Segment segment : flight.getSegments()) {
                        // Проверка, что дата прибытия не раньше даты отправления
                        if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                            return false; // исключить этот рейс
                        }
                    }
                    return true; // оставить этот рейс
                })
                .collect(Collectors.toList());
    }
}