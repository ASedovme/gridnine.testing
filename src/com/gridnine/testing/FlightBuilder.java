package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для создания тестовых данных — рейсов с различными сценариями.
 */
public class FlightBuilder {

    /**
     * Создает список тестовых рейсов с разными характеристиками для проверки фильтров.
     *
     * @return список объектов Flight с подготовленными сегментами
     */
    public static List<Flight> createFlights() {
        List<Flight> flights = new ArrayList<>();

        // Текущая дата и время для тестовых данных
        LocalDateTime now = LocalDateTime.now();

        // Перелёт 1: Вылет в прошлом (должен быть отфильтрован)
        flights.add(new Flight(List.of(
                new Segment(now.minusDays(2), now.minusDays(2).plusHours(2))
        )));

        // Перелёт 2: Вылет через 1 час (будущий)
        flights.add(new Flight(List.of(
                new Segment(now.plusHours(1), now.plusHours(3))
        )));

        // Перелёт 3: Некорректные даты сегментов (прилет раньше вылета)
        flights.add(new Flight(List.of(
                new Segment(now.plusDays(1), now.plusDays(1).minusHours(1))
        )));

        // Перелёт 4: Время на земле более двух часов между сегментами
        flights.add(new Flight(List.of(
                new Segment(now.plusDays(1), now.plusDays(1).plusHours(2)),
                new Segment(now.plusDays(1).plusHours(4), now.plusDays(1).plusHours(6))
        )));

        // Перелёт 5: Корректный перелёт с несколькими сегментами (время на земле менее двух часов)
        flights.add(new Flight(List.of(
                new Segment(now.plusDays(2), now.plusDays(2).plusHours(2)),
                new Segment(now.plusDays(2).plusHours(3), now.plusDays(2).plusHours(5))
        )));

        return flights;
    }
}