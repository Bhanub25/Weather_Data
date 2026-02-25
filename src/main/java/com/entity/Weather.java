package com.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DELHI_WEATHER")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weather_seq")
    @SequenceGenerator(
            name = "weather_seq",
            sequenceName = "WEATHER_SEQ",
            allocationSize = 1
    )
    @Column(name = "ID")
    private Long id;

    
    @Temporal(TemporalType.DATE)
    @Column(name = "OBS_DATE")
    private Date obsDate;

    @Column(name = "WEATHER_CONDITION")
    private String weatherCondition;

    @Column(name = "TEMP_C")
    private Double tempC;

    @Column(name = "HUMIDITY")
    private Double humidity;

    @Column(name = "PRESSURE")
    private Double pressure;

    @Column(name = "HEAT_INDEX")
    private Double heatIndex;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public Double getHeatIndex() { return heatIndex; }
    public void setHeatIndex(Double heatIndex) { this.heatIndex = heatIndex; }
}