package com.sunrise.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "sunrise_data")
public class SunriseData {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "sunrise")
    private String sunrise;

    @Column(name = "sunset")
    private String sunset;

    @Column(name = "solar_noon")
    private String solarNoon;

    @Column(name = "day_length")
    private String dayLength;

    @Column(name = "civil_twilight_begin")
    private String civilTwilightBegin;

    @Column(name = "civil_twilight_end")
    private String civilTwilightEnd;

    @Column(name = "nautical_twilight_begin")
    private String nauticalTwilightBegin;

    @Column(name = "nautical_twilight_end")
    private String nauticalTwilightEnd;

    @Column(name = "astronomical_twilight_begin")
    private String astronomicalTwilightBegin;

    @Column(name = "astronomical_twilight_end")
    private String astronomicalTwilightEnd;

    @Column(name = "timestamp")
    private Instant timestamp;

}
