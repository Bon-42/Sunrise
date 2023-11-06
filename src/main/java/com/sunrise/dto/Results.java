package com.sunrise.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {

        @JsonProperty("sunrise")
        String sunrise;
        @JsonProperty("sunset")
        String sunset;
        @JsonProperty("solar_noon")
        String solarNoon;
        @JsonProperty("day_length")
        String dayLength;
        @JsonProperty("civil_twilight_begin")
        String civilTwilightBegin;
        @JsonProperty("civil_twilight_end")
        String civilTwilightEnd;
        @JsonProperty("nautical_twilight_begin")
        String nauticalTwilightBegin;
        @JsonProperty("nautical_twilight_end")
        String nauticalTwilightEnd;
        @JsonProperty("astronomical_twilight_begin")
        String astronomicalTwilightBegin;
        @JsonProperty("astronomical_twilight_end")
        String astronomicalTwilightEnd;
    }


