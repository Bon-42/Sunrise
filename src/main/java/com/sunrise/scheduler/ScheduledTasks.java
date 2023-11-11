package com.sunrise.scheduler;

import com.sunrise.service.SunriseSunsetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    SunriseSunsetDataService sunriseSunsetDataService;

    @Scheduled(cron = "0 10 * * * ?", zone="MST")
    public void executeTask() throws Exception {
        sunriseSunsetDataService.saveSunriseSunsetData();
    }
}
