package utils;
//States. provinces, territory, districts, divisions, municipalities, regions, departments, cities, governorate, dependency, prefecture, canton, islands 
public class States {
    private String name, country, type, latitude, longitude;


    public States() {
		this.name = "Unknown";
		this.country = "Unknown";
		this.type = "Unknown";
		this.latitude = "Unknown";
		this.longitude = "Unknown";

	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param name
	 * @param country
	 * @param type
	 * @param latitude
	 * @param longitude

	 */
	public States(String name, String country,String type, String latitude,String longitude) {
		this.name = name;
		this.country = country;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
        return "Country: " + name + " | " + country + " | " + type + " | " + latitude + " | "+ longitude;
	}

}


