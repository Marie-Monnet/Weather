package com.howtodoinjava.demo.model;

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

	private String cityName;
	private Integer zipCode;
	private String country;
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
