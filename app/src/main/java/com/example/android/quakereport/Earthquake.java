package com.example.android.quakereport;

/**
 * Contains all the required data for an earthquake
 */
public class Earthquake {

    private double magnitude;
    private String location;
    private Long mTimeInMilliseconds;
    private String mUrl;

    public Earthquake(double magnitude, String location, Long timeInMilliseconds, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
        this.mUrl = url;
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

    public String getUrl() {
        return mUrl;
    }
}
