package com.sunrise.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "sunrise_data")
public class SunriseSunsetData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sunrise;
    private String sunset;
    private String solarNoon;
    private String dayLength;
    private String civilTwilightBegin;
    private String civilTwilightEnd;
    private String nauticalTwilightBegin;
    private String nauticalTwilightEnd;
    private String astronomicalTwilightBegin;
    private String astronomicalTwilightEnd;
    private LocalDate recordDate;

}
