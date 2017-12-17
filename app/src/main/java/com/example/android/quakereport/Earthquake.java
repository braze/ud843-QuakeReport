package com.example.android.quakereport;

/**
 * Created by braze on 12/10/17.
 */

public class Earthquake {

    private Double mMagnitude;
    private Long mDate;
    private String mLocation;
    private String mUrl;

    public Earthquake(Double mMagnitude, String mLocation, Long mDate, String mUrl) {
        this.mMagnitude = mMagnitude;
        this.mDate = mDate;
        this.mLocation = mLocation;
        this.mUrl = mUrl;
    }

    public Double getMagnitude() {
        return mMagnitude;
    }

    public Long getDate() {
        return mDate;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getUrl() {
        return mUrl;
    }
}
