package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр, который исключает рейсы, у которых время между сегментами превышает два часа.
 */
public class GroundTimeExceedsTwoHoursFilter implements FlightFilter {

    /**
     * Фильтрует список рейсов, исключая те, у которых есть промежутки между сегментами более двух часов.
     *
     * @param flights список рейсов для фильтрации
     * @return список рейсов без промежутков между сегментами более двух часов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    for (int i = 0; i < segments.size() - 1; i++) {
                        Segment current = segments.get(i);
                        Segment next = segments.get(i + 1);
                        // Вычисляем разницу во времени между прибытие текущего сегмента и отправлением следующего
                        long groundMinutes = java.time.Duration.between(current.getArrivalDate(), next.getDepartureDate()).toMinutes();
                        if (groundMinutes > 120) { // если промежуток больше двух часов
                            return false; // исключить этот рейс
                        }
                    }
                    return true; // оставить этот рейс
                })
                .collect(Collectors.toList());
    }
}