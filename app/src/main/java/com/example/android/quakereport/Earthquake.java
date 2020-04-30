package com.example.android.quakereport;

/**
 * Contains all the required data for an earthquake
 */
public class Earthquake {

    private double magnitude;
    private String location;
    private Long mTimeInMilliseconds;

    public Earthquake(double magnitude, String location, Long timeInMilliseconds) {
        this.magnitude = magnitude;
        this.location = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public Long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
