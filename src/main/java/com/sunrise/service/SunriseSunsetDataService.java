package com.sunrise.service;

import com.sunrise.client.ExternalApiService;
import com.sunrise.dto.Result;
import com.sunrise.dto.Results;
import com.sunrise.models.SunriseData;
import com.sunrise.repository.SunriseSunsetDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
public class SunriseSunsetDataService {

    @Autowired
    ExternalApiService serviceCall;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private SunriseSunsetDataRepository repository;

    public SunriseSunsetDataService() throws Exception {
    }


    public void saveSunriseSunsetData() throws Exception {

        Result response = serviceCall.getTimesFromExternalApi(restTemplate);
        Results results = response.getResults();
        SunriseData data = new SunriseData();

        // save the info we got from the api call to the database
        data.setId(UUID.randomUUID());
        data.setSunrise(results.getSunrise());
        data.setSunset(results.getSunset());
        data.setSolarNoon(results.getSolarNoon());
        data.setDayLength(results.getDayLength());
        data.setCivilTwilightBegin(results.getCivilTwilightBegin());
        data.setCivilTwilightEnd(results.getCivilTwilightEnd());
        data.setNauticalTwilightBegin(results.getNauticalTwilightBegin());
        data.setNauticalTwilightEnd(results.getNauticalTwilightEnd());
        data.setAstronomicalTwilightBegin(results.getAstronomicalTwilightBegin());
        data.setAstronomicalTwilightEnd(results.getAstronomicalTwilightEnd());
        data.setTimestamp(Instant.now());

        repository.save(data);
    }

    public List<SunriseData> getSunriseSunsetByDate(LocalDate date) throws Exception {
        ZoneId zoneId = ZoneId.of("UTC-07");
        Instant startOfDay = date.atStartOfDay(zoneId).toInstant();
        Instant startOfNextDay = date.plusDays(1).atStartOfDay(zoneId).toInstant();

        return repository.findByRecordDate(startOfDay, startOfNextDay);
    }

    public List<SunriseData> getAllSunriseSunsetData() {
        return repository.findAll();
    }

    /*
    public void deleteSunriseSunsetData(Long id) {
        repository.deleteById(id);
    }

    public SunriseSunsetData updateSunriseSunsetData(Long id, SunriseSunsetData data) {
        SunriseSunsetData existingData = getSunriseSunsetDataById(id);
        // Update properties
        // existingData.setSunrise(data.getSunrise());
        // and so on for other fields...
        return saveSunriseSunsetData(existingData);
    }

     */
}
