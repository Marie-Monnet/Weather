package com.example.workshopmicroservices.springhystrixweatherservice.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class WeatherServiceDelegate {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callWeatherServiceAndGetData_Fallback")
	public String callWeatherServiceAndGetData(String cityName) {
		System.out.println("Getting weather details for " + cityName);
		String response = restTemplate
				.exchange("http://localhost:8098/getWeatherDetailsForCity/{cityName}"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, cityName).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - City Name -  " + cityName + " :::  city Details " + response + " -  " + new Date();
	}
	
	@SuppressWarnings("unused")
	private String callWeatherServiceAndGetData_Fallback(String cityName) {
		System.out.println("Weather Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Weather Service at this moment. Service will be back shortly - " + new Date();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
