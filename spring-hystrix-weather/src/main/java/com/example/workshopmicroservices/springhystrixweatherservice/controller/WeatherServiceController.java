package com.example.workshopmicroservices.springhystrixweatherservice.controller;

import com.example.workshopmicroservices.springhystrixweatherservice.delegate.WeatherServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherServiceController {
	
	@Autowired
    WeatherServiceDelegate weatherServiceDelegate;

	@RequestMapping(value = "/getWeatherDetails/{cityName}", method = RequestMethod.GET)
	public String getWeathers(@PathVariable String cityName) {
		System.out.println("Going to call weather service to get data!");
		return weatherServiceDelegate.callWeatherServiceAndGetData(cityName);
	}
	
}
