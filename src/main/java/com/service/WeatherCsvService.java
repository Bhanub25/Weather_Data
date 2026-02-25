package com.service;

import com.entity.Weather;
import com.repository.WeatherRepo;
import com.util.CsvUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherCsvService {

    private final WeatherRepo repo;

    public WeatherCsvService(WeatherRepo repo) {
        this.repo = repo;
    }

    public long uploadCsv(MultipartFile file) throws Exception {

        long total = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            String header = br.readLine(); 
            if (header == null) return 0;

            String line;
            List<Weather> batch = new ArrayList<>(1000);

            while ((line = br.readLine()) != null) {
                
                String[] d = line.split(",", -1);

                
                if (d.length < 12) continue;

                Weather w = new Weather();
                w.setObsDate(CsvUtil.parseObsDate(d[0])); 
                if (w.getObsDate() == null) continue;
                
                w.setWeatherCondition(CsvUtil.cleanString(d[1]));  
                w.setHeatIndex(CsvUtil.cleanDouble(d[5]));         
                w.setHumidity(CsvUtil.cleanDouble(d[6]));          
                w.setPressure(CsvUtil.cleanDouble(d[8]));          
                w.setTempC(CsvUtil.cleanDouble(d[11]));            

                batch.add(w);

                
                if (batch.size() == 1000) {
                    repo.saveAll(batch);
                    total += batch.size();
                    batch.clear();
                }
            }

            if (!batch.isEmpty()) {
                repo.saveAll(batch);
                total += batch.size();
            }
        }

        return total;
    }
}