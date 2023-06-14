package utils;

public class Independance {
    private String name, independanceDay, year;
    // private List<States> states;
    // private List<Cities>;

    public Independance() {
		this.name = "Unknown";
		this.independanceDay = "Unknown";
		this.year = "Unknown";
		

	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param name
	 * @param independanceDay
	 * @param year
	 */
	public Independance(String name, String independanceDay, String year) {
		this.name = name;
		this.independanceDay = independanceDay;
		this.year = year;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public String getIndependanceDay() {
    
		return independanceDay;
	}

	public void setIndependanceDay(String independanceDay) {
		this.independanceDay = independanceDay;
	}

	public String getYear() {
		return year;
	}

	public void getYear(String year) {
		this.year = year;
	}


	@Override
	public String toString() {
        return "Country: " + name + " | " + independanceDay + " | " + year ;
	}

}


