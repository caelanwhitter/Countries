package utils;

import java.util.*;

public class Population {
    private String country, continent, population22, population20, population15, population10, area, populationPercent;


    public Population() {
		this.country = "Unknown";
		this.continent = "Unknown";
		this.area = "Unknown";
	   	this.populationPercent = "Unknown";
		this.population22 = "Unknown";
		this.population20 = "Unknown";
		this.population15 = "Unknown";
		this.population10 = "Unknown";
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param country
	 * @param continent
	 * @param area
	 * @param populationPercent
	 * @param population22
	 * @param population20
	 * @param population15
	 * @param population10
	 */
	public Population(String country, String continent,String area, String populationPercent, String population22,String population20, String population15, String population10) {
		this.country = country;
		this.continent = continent;
		this.area = area;
		this.populationPercent = populationPercent;
		this.population22 = population22;
		this.population20 = population20;
		this.population15 = population15;
		this.population10 = population10;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
		return "Country: " + country + " | " + continent + " | "  + area + " | " + populationPercent + " | " + population22 + " | " + population20 + 
      " | " + population15 + " | " + population10 + " | " ;
	}

}







