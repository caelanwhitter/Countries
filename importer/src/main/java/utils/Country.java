package utils;
import org.bson.types.*;

public class Country {
    private String name, capital, currency, region, latitude, longitude, population22, population20, population15, population10;
    // private List<States> states;
    // private List<Cities>;

    public Country() {
		this.name = "Unknown";
		this.capital = "Unknown";
		this.currency = "Unknown";
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
     * @param region
	 * @param latitude
	 * @param longitude
	 * @param population22
	 * @param population20
	 * @param population15
	 * @param population10
	 */
	public Country(String name, String capital, String currency,String region, String latitude,String longitude, String population22,
			String population20, String population15, String population10) {
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.genre = genre;
		this.rating = rating;
		this.poster = poster;
		this.director = director;
		this.score = score;
		this.gross = gross;
		this.releaseYear = releaseYear;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getGross() {
		return gross;
	}

	public void setGross(String gross) {
		this.gross = gross;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {
		return "MOVIE: " + description + " | " + director + " | " + duration + " | " + genre + " | " + gross + " | "
				+ poster + " | "
				+ rating + " | " + releaseYear + " | " + score + " | " + title;
	}

}

}
