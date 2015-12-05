package pt.belele.project.controllers.util;


public class H2H {

	private Double rating;
	private Integer size;
	private Integer numberResults;
//	private Double ratingVenue;
//	private Integer sizeVenue;
//	private Integer numberResultsVenue;
//	private Double ratingSwitchedVenue;
//	private Integer sizeSwitchedVenue;
//	private Integer numberResultsSwitchedVenue;

	public H2H(Double rating, Integer size, int numberResults/*, Double ratingVenue, Integer sizeVenue, int numberResultsVenue, Double ratingSwitchedVenue, Integer sizeSwitchedVenue, int numberResultsSwitchedVenue*/) {
		this.rating = rating;
		this.size = size;
		this.numberResults = numberResults;
//		this.ratingVenue = ratingVenue;
//		this.sizeVenue = sizeVenue;
//		this.numberResultsVenue = numberResultsVenue;
//		this.ratingSwitchedVenue = ratingSwitchedVenue;
//		this.sizeSwitchedVenue = sizeSwitchedVenue;
//		this.numberResultsSwitchedVenue = numberResultsSwitchedVenue;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getSize() {
		return size;	
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getNumberResults() {
		return numberResults;
	}

	public void setNumberResults(Integer numberResults) {
		this.numberResults = numberResults;
	}
}
