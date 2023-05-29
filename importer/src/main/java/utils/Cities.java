package utils;

public class Cities {
    private String name, country, latitude, longitude;
    // private List<States> states;
    // private List<Cities>;

    public Cities() {
		this.name = "Unknown";
		this.country = "Unknown";
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
	public Cities(String name, String country, String latitude,String longitude) {
		this.name = name;
		this.country = country;
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
        return "Country: " + name + " | " + country + " | " + latitude + " | "+ longitude;
	}

}


