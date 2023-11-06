package com.sunrise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SunriseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SunriseApplication.class, args);
	}

}
