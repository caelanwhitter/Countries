package utils;

import java.util.*;

public class Country {
    private String name, capital, currency, currencyName, currencySymbol,countryCode, region, latitude, longitude;


    public Country() {
		this.name = "Unknown";
		this.capital = "Unknown";
		this.currency = "Unknown";
	   	this.currencyName = "Unknown";
	   	this.currencySymbol = "Unknown";
	        this.countryCode = "Unknown";
		this.region = "Unknown";
		this.latitude = "Unknown";
		this.longitude = "Unknown";

	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param name
	 * @param capital
	 * @param currency
	 * @param currencyName
	 * @param currencySymbol
	 * @param countryCode
     	 * @param region
	 * @param latitude
	 * @param longitude

	 */
	public Country(String name, String capital,String region, String currency,  String currencyName, String currencySymbol, String countryCode, String latitude,String longitude) {
		this.name = name;
		this.capital = capital;
		this.currency = currency;
		this.countryCode = countryCode;
		this.currency = currencyName;
		this.currency = currencySymbol;
		this.region = region;
		this.latitude = latitude;
		this.longitude = longitude;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}




	@Override
	public String toString() {
		return "Country: " + name + " | " + capital + " | " + region + " | " + currency +  " | " + currencyName + " | " + currencySymbol +
			" | " + latitude + " | "+ longitude;
	}

}


