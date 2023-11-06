package com.sunrise.client;

import com.sunrise.dto.Result;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public Result getTimesFromExternalApi(RestTemplate restTemplate) throws Exception {
        Result result = restTemplate.getForObject("https://api.sunrise-sunset.org/json?lat=36.7201600&lng=-4.4203400", Result.class);
        return result;
    }
}
