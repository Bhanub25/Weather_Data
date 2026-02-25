package com.service;

import com.controller.MonthTempStats;
import com.controller.WeatherResponse;
import com.entity.Weather;
import com.repository.WeatherRepo;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherQueryService {

    private final WeatherRepo repo;

    public WeatherQueryService(WeatherRepo repo) {
        this.repo = repo;
    }

    
    public List<WeatherResponse> getByDate(String yyyyMmDd) {
        List<Weather> list = repo.findByDate(Date.valueOf(yyyyMmDd));
        return list.stream()
                .map(w -> new WeatherResponse(
                        w.getObsDate(),
                        w.getWeatherCondition(),
                        w.getTempC(),
                        w.getHumidity(),
                        w.getPressure()
                ))
                .toList();
    }

    
    public List<WeatherResponse> getByMonth(String yyyyMm) {
        LocalDate start = LocalDate.parse(yyyyMm + "-01");
        LocalDate end = start.plusMonths(1);

        List<Weather> list = repo.findByRange(Date.valueOf(start), Date.valueOf(end));
        return list.stream()
                .map(w -> new WeatherResponse(
                        w.getObsDate(),
                        w.getWeatherCondition(),
                        w.getTempC(),
                        w.getHumidity(),
                        w.getPressure()
                ))
                .toList();
    }

    
    public List<MonthTempStats> getMonthlyStats(int year) {
        return repo.monthlyTempStats(year).stream()
                .map(r -> new MonthTempStats(
                        ((Number) r[0]).intValue(),
                        r[1] == null ? null : ((Number) r[1]).doubleValue(),
                        r[2] == null ? null : ((Number) r[2]).doubleValue(),
                        r[3] == null ? null : ((Number) r[3]).doubleValue()
                ))
                .toList();
    }
}