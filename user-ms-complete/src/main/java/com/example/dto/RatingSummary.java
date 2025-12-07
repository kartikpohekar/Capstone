package com.example.dto;

public class RatingSummary {

    private double average;
    private long count;

    public RatingSummary(double average, long count) {
        this.average = average;
        this.count = count;
    }

    public double getAverage() { return average; }
    public void setAverage(double average) { this.average = average; }

    public long getCount() { return count; }
    public void setCount(long count) { this.count = count; }
}
