package com.sunrise.repository;

import com.sunrise.models.SunriseSunsetData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SunriseSunsetDataRepository extends JpaRepository<SunriseSunsetData, Long> {
}
