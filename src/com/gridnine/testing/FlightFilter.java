package com.gridnine.testing;

import java.util.List;

/**
 * Интерфейс для фильтрации списка рейсов по определённым критериям.
 */
public interface FlightFilter {
    /**
     * Фильтрует список рейсов, возвращая только те, которые соответствуют определённым условиям.
     *
     * @param flights исходный список рейсов
     * @return список рейсов, прошедших фильтрацию
     */
    List<Flight> filter(List<Flight> flights);
}
