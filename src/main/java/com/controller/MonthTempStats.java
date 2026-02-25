package com.controller;

public class MonthTempStats {
    private int month;
    private Double minTemp;
    private Double medianTemp;
    private Double maxTemp;

    public MonthTempStats() {}

    public MonthTempStats(int month, Double minTemp, Double medianTemp, Double maxTemp) {
        this.month = month;
        this.minTemp = minTemp;
        this.medianTemp = medianTemp;
        this.maxTemp = maxTemp;
    }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public Double getMinTemp() { return minTemp; }
    public void setMinTemp(Double minTemp) { this.minTemp = minTemp; }

    public Double getMedianTemp() { return medianTemp; }
    public void setMedianTemp(Double medianTemp) { this.medianTemp = medianTemp; }

    public Double getMaxTemp() { return maxTemp; }
    public void setMaxTemp(Double maxTemp) { this.maxTemp = maxTemp; }
}