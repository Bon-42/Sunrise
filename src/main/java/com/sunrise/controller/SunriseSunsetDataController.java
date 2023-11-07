package com.sunrise.controller;

import com.sunrise.models.SunriseSunsetData;
import com.sunrise.service.SunriseSunsetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sunrisesunset")
public class SunriseSunsetDataController {
        @Autowired
        SunriseSunsetDataService service;

        @Autowired
        RestTemplate restTemplate;

        @GetMapping
        public List<SunriseSunsetData> getAllSunriseSunsetData() throws Exception {
                return service.getAllSunriseSunsetData();
        }

        @GetMapping("/{date}")
        public SunriseSunsetData getSunriseSunsetDataById(
                @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws Exception {
                return service.getSunriseSunsetByDate (date);
        }

        /*
        @Autowired
        private SunriseSunsetDataService service;

        @PostMapping
        public SunriseSunsetData addSunriseSunsetData(@RequestBody SunriseSunsetData data) {
            return service.saveSunriseSunsetData(data);
        }

        @GetMapping("/{id}")
        public SunriseSunsetData getSunriseSunsetDataById(@PathVariable Long id) {
            return service.getSunriseSunsetDataById(id);
        }

        @DeleteMapping("/{id}")
        public String deleteSunriseSunsetData(@PathVariable Long id) {
            service.deleteSunriseSunsetData(id);
            return "Deleted successfully";
        }

        @PutMapping("/{id}")
        public SunriseSunsetData updateSunriseSunsetData(@PathVariable Long id, @RequestBody SunriseSunsetData data) {
            return service.updateSunriseSunsetData(id, data);
        }
        */

}

