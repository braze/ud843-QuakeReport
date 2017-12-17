package com.example.android.quakereport;

/**
 * Created by braze on 12/10/17.
 */

public class Earthquake {

    private Double mMagnitude;
    private Long mDate;
    private String mLocation;

    public Earthquake(Double mMagnitude, String mLocation, Long mDate) {
        this.mMagnitude = mMagnitude;
        this.mDate = mDate;
        this.mLocation = mLocation;
    }

    public Double getmMagnitude() {
        return mMagnitude;
    }

    public Long getmDate() {
        return mDate;
    }

    public String getmLocation() {
        return mLocation;
    }
}
