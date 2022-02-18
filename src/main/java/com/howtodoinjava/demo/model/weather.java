package com.howtodoinjava.demo.model;

import io.swagger.annotations.ApiModelProperty;

public class weather {

	public weather() {
		
	}
	public weather(String cityName, Integer zipCode, String country, String temperature) {
		super();
		this.cityName = cityName;
		this.zipCode = zipCode;
		this.country = country;
		this.temperature = temperature;
	}

	@ApiModelProperty(notes = "Name of the City",name="cityName",required=true,value="test city name")
	private String cityName;
	@ApiModelProperty(notes = "Value of the Zip Code",name="zipCode",required=true,value="test zip code")
	private Integer zipCode;
	@ApiModelProperty(notes = "Name of the Country",name="country",required=true,value="test country")
	private String country;
	@ApiModelProperty(notes = "Value of the temperature",name="temperature",required=true,value="test temperature")
	private String temperature;

	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) { this.zipCode = zipCode;}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "Weather [City=" + cityName + ", Zip Code=" + zipCode
				+ ", Country=" + country + ", Temperature=" + temperature + "]";
	}
}
