package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.howtodoinjava.demo.model.weather;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "WeatherController", description = "REST Apis related to Weather Entity!!!!")
@RestController
public class WeatherController {

    List<weather> weathers = new ArrayList<weather>();
    {
        weathers.add(new weather("Marseille", 13000, "FR", "It's 16 degrees"));
        weathers.add(new weather("Toulon", 83000, "FR", "It's 20 degrees"));
        weathers.add(new weather("Rome", 12345, "IT", "It's 35 degrees"));
        weathers.add(new weather("Toronto", 67890, "CA", "It's 5 degrees"));
    }

    @ApiOperation(value = "Get list of Weathers in the System ", response = Iterable.class, tags = "getWeathers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    //Get all weathers in all cities
    @RequestMapping(value = "/getWeathers")
    public List<weather> getWeathers() {
        return weathers;
    }

    //Get weather in a specific city
    @ApiOperation(value = "Get specific city in the System ", response = weather.class, tags = "getWeather")
    @RequestMapping(value = "/getWeather/{cityName}")
    public weather getWeather(@PathVariable(value = "cityName") String cityName) {
        return weathers.stream().filter(x -> x.getCityName().equalsIgnoreCase(cityName)).collect(Collectors.toList()).get(0);
    }

    //Get weather in a specific country
    @ApiOperation(value = "Get specific city By Country in the System ", response = weather.class, tags = "getCityByCountry")
    @RequestMapping(value = "/getCityByCountry/{country}")
    public List<weather> getCityByCountry(@PathVariable(value = "country") String country) {
        System.out.println("Searching City in country : " + country);
        List<weather> CityByCountry = weathers.stream().filter(x -> x.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
        System.out.println(CityByCountry);
        return CityByCountry;
    }

    //Get weather with a specific zip code
    @ApiOperation(value = "Get specific city By Zipcode in the System ",response = weather.class,tags="getCityByZip")
    @RequestMapping(value = "/getCityByZip/{zipCode}")
    public List<weather> getWeatherByZip(@PathVariable(value = "zipCode") Integer zipCode) {
        return weathers.stream().filter(x -> x.getZipCode().equals(zipCode)).collect(Collectors.toList());
    }

}
