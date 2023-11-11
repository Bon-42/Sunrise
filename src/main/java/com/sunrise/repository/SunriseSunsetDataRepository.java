package com.sunrise.repository;

import com.sunrise.models.SunriseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface SunriseSunsetDataRepository extends JpaRepository<SunriseData, UUID> {
    @Query("SELECT y FROM SunriseData y WHERE y.timestamp >= :startOfDay AND y.timestamp < :startOfNextDay")
    List<SunriseData> findByRecordDate(@Param("startOfDay") Instant startOfDay, @Param("startOfNextDay") Instant startOfNextDay);
}
