package com.repository;

import com.entity.Weather;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;

public interface WeatherRepo extends JpaRepository<Weather, Long> {

    @Query("FROM Weather w WHERE w.obsDate = :d ORDER BY w.id")
    List<Weather> findByDate(@Param("d") Date d);

    @Query("FROM Weather w WHERE w.obsDate >= :start AND w.obsDate < :end ORDER BY w.obsDate")
    List<Weather> findByRange(@Param("start") Date start, @Param("end") Date end);

    @Query(value = """
      SELECT
        EXTRACT(MONTH FROM OBS_DATE) AS month,
        MIN(TEMP_C) AS min_temp,
        MEDIAN(TEMP_C) AS median_temp,
        MAX(TEMP_C) AS max_temp
      FROM DELHI_WEATHER
      WHERE EXTRACT(YEAR FROM OBS_DATE) = :year
      GROUP BY EXTRACT(MONTH FROM OBS_DATE)
      ORDER BY month
    """, nativeQuery = true)
    List<Object[]> monthlyTempStats(@Param("year") int year);
}