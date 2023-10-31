package com.sunrise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @Autowired
    CallExternalApi callExternalApi;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/sunrises")
   Result all() throws Exception {
        return  callExternalApi.getPricesFromExternalApi(restTemplate);
    }
}

