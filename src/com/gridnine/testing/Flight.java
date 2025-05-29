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
}