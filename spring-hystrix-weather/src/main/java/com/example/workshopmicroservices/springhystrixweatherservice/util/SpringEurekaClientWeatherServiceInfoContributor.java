package com.example.workshopmicroservices.springhystrixweatherservice.util;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class SpringEurekaClientWeatherServiceInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("details",
				Collections.singletonMap("description", "This is the Weather service, which is discovery server aware, and this service will Call Weather Microservice, fro weather details, which is again dicovery server aware!!! "));
	}

}
