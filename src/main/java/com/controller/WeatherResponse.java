package com.controller;

import java.util.Date;

public class WeatherResponse {
    private Date obsDate;
    private String weatherCondition;
    private Double tempC;
    private Double humidity;
    private Double pressure;

    public WeatherResponse() {}

    public WeatherResponse(Date obsDate, String weatherCondition, Double tempC, Double humidity, Double pressure) {
        this.obsDate = obsDate;
        this.weatherCondition = weatherCondition;
        this.tempC = tempC;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public Date getObsDate() { return obsDate; }
    public void setObsDate(Date obsDate) { this.obsDate = obsDate; }

    public String getWeatherCondition() { return weatherCondition; }
    public void setWeatherCondition(String weatherCondition) { this.weatherCondition = weatherCondition; }

    public Double getTempC() { return tempC; }
    public void setTempC(Double tempC) { this.tempC = tempC; }

    public Double getHumidity() { return humidity; }
    public void setHumidity(Double humidity) { this.humidity = humidity; }

    public Double getPressure() { return pressure; }
    public void setPressure(Double pressure) { this.pressure = pressure; }
}