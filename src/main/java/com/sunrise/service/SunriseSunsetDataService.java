package com.sunrise.service;

import com.sunrise.client.ExternalApiService;
import com.sunrise.dto.Result;
import com.sunrise.dto.Results;
import com.sunrise.models.SunriseSunsetData;
import com.sunrise.repository.SunriseSunsetDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

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

        SunriseSunsetData data = new SunriseSunsetData();
        // save the info we got from the api call to the database
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
        data.setRecordDate(LocalDateTime.now(ZoneId.of("America/Denver")).toLocalDate());

         repository.save(data);

    }

    public SunriseSunsetData getSunriseSunsetByDate(LocalDate date) throws Exception {
        return repository.findByRecordDate(date);

    }

    public List<SunriseSunsetData> getAllSunriseSunsetData() {
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
