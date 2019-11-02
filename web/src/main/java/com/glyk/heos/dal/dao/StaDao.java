package com.glyk.heos.dal.dao;

import java.text.DecimalFormat;

public class StaDao {
    private String average;
    private String max;
    private String min;
    private String std;
    public String getAverage() {

        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {

        return min;
    }

    public void setMin(String min) {

        this.min = min;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {

        this.std = std;
    }
}
