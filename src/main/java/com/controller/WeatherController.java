package com.controller;

import com.service.WeatherCsvService;
import com.service.WeatherQueryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherCsvService csvService;
    private final WeatherQueryService queryService;

    public WeatherController(WeatherCsvService csvService, WeatherQueryService queryService) {
        this.csvService = csvService;
        this.queryService = queryService;
    }

    
    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file) throws Exception {
        long rows = csvService.uploadCsv(file);
        return Map.of("status", "ok", "rowsInserted", rows);
    }


    @GetMapping("/date")
    public List<WeatherResponse> byDate(@RequestParam("d") String date) {
        return queryService.getByDate(date);
    }

    
    
    @GetMapping("/month")
    public List<WeatherResponse> byMonth(@RequestParam("m") String month) {
        return queryService.getByMonth(month);
    }

    
    @GetMapping("/stats/{year}")
    public List<MonthTempStats> stats(@PathVariable int year) {
        return queryService.getMonthlyStats(year);
    }
}