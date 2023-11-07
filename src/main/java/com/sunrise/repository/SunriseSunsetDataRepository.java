package com.sunrise.repository;

import com.sunrise.models.SunriseSunsetData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SunriseSunsetDataRepository extends JpaRepository<SunriseSunsetData, Long> {
    @Query(value = "SELECT * FROM sunrise_data WHERE record_date = :date LIMIT 1", nativeQuery = true)
    SunriseSunsetData findByRecordDate(@Param("date") LocalDate recordDate);

}
