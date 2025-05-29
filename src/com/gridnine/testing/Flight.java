package com.gridnine.testing;


import java.util.List;

/**
 * Класс, представляющий рейс, состоящий из одного или нескольких сегментов.
 */
public class Flight {
    /**
     * Список сегментов, входящих в рейс.
     */
    private List<Segment> segments;

    /**
     * Конструктор для создания объекта Flight с указанным списком сегментов.
     *
     * @param segments список сегментов рейса
     */
    public Flight(List<Segment> segments) {
        this.segments = segments;
    }

    /**
     * Возвращает список сегментов рейса.
     *
     * @return список сегментов
     */
    public List<Segment> getSegments() {
        return segments;
    }

    /**
     * Возвращает строковое представление рейса и его сегментов.
     *
     * @return строковое описание рейса
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Перелёт:\n");
        int segmentNumber = 1;
        for (Segment segment : segments) {
            sb.append("  Сегмент ").append(segmentNumber).append(": ").append(segment).append("\n");
            segmentNumber++;
        }
        return sb.toString();
    }
}