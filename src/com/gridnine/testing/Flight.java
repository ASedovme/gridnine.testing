package com.gridnine.testing;


import java.util.List;

public class Flight {
    private List<Segment> segments;

    public Flight(List<Segment> segments) {
        this.segments = segments;
    }

    public List<Segment> getSegments() {
        return segments;
    }

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