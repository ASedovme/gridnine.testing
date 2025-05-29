package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс, представляющий сегмент полёта с датой вылета и прилёта.
 */
public class Segment {
    /**
     * Дата и время вылета сегмента.
     */
    private LocalDateTime departureDate;

    /**
     * Дата и время прилёта сегмента.
     */
    private LocalDateTime arrivalDate;

    /**
     * Конструктор для создания сегмента с указанными датами.
     *
     * @param departureDate дата и время вылета
     * @param arrivalDate   дата и время прилёта
     */
    public Segment(LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    /**
     * Возвращает дату и время вылета сегмента.
     *
     * @return дата и время вылета
     */
    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    /**
     * Возвращает дату и время прилёта сегмента.
     *
     * @return дата и время прилёта
     */
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Возвращает строковое представление сегмента с форматированными датами.
     *
     * @return строковое описание сегмента
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Вылет: " + departureDate.format(formatter) +
                ", Прилет: " + arrivalDate.format(formatter);
    }
}