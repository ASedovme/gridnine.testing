package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр, который исключает рейсы, у которых дата отправления первого сегмента раньше текущего времени.
 */
public class DepartureBeforeNowFilter implements FlightFilter {

    /**
     * Фильтрует список рейсов, исключая те, у которых первый сегмент отправляется раньше текущего времени.
     *
     * @param flights список рейсов для фильтрации
     * @return список рейсов, у которых дата отправления первого сегмента после текущего времени
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                // Проверяем дату отправления первого сегмента каждого рейса
                .filter(flight -> flight.getSegments().get(0).getDepartureDate().isAfter(now))
                .collect(Collectors.toList());
    }
}