package utils;

import java.util.*;

public class Population {
    private String name, capital, currency, currencyName, currencySymbol, region, latitude, longitude, population22, population20, population15, population10;


    public Population() {
		this.name = "Unknown";
		this.capital = "Unknown";
		this.currency = "Unknown";
	   	this.currencyName = "Unknown";
	   	this.currencySymbol = "Unknown";
		this.region = "Unknown";
		this.latitude = "Unknown";
		this.longitude = "Unknown";
		this.population22 = "Unknown";
		this.population20 = "Unknown";
		this.population15 = "Unknown";
		this.population10 = "Unknown";
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param name
	 * @param capital
	 * @param currency
	 * @param currencyName
	 * @param currencySymbol
     	 * @param region
	 * @param latitude
	 * @param longitude
	 * @param population22
	 * @param population20
	 * @param population15
	 * @param population10
	 */
	public Population(String name, String capital,String region, String currency, String currencyName, String currencySymbol, String latitude,String longitude, String population22,
			String population20, String population15, String population10) {
		this.name = name;
		this.capital = capital;
		this.currency = currency;
		this.currency = currencyName;
		this.currency = currencySymbol;
		this.region = region;
		this.latitude = latitude;
		this.longitude = longitude;
		this.population22 = population22;
		this.population20 = population20;
		this.population15 = population15;
		this.population10 = population10;
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
	
	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	public String getPopulationPercent() {
		return populationPercent;
	}

	public void setPopulationPercent(String populationPercent) {
		this.populationPercent = populationPercent;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPopulation22() {
		return population22;
	}

	public void setPopulation22(String population22) {
		this.population22 = population22;
	}

	public String getPopulation20() {
		return population20;
	}

	public void setPopulation20(String population20) {
		this.population20 = population20;
	}

	public String getPopulation15() {
		return population15;
	}

	public void setPopulation15(String population15) {
		this.population15 = population15;
	}

	public String getPopulation10() {
		return population10;
	}

	public void setPopulation10(String population10) {
		this.population10 = population10;
	}


	@Override
	public String toString() {
		return "Country: " + country + " | " + continent + " | " + population22 + " | " + population20 + 
      " | " + population15 + " | " + population10 + " | " + area + " | " + populationPercent +;
	}

}






// country=2
// continent=4
// 22=5
// 20=6
// 15=7
// 10=8
// area=12
// populationpercentage=15
