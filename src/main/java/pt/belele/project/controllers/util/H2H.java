package pt.belele.project.controllers.util;

public class H2H {

	private Double rating;
	private Integer size;
	private Integer numberResults;

	public H2H(Double rating, Integer size, int numberResults) {
		this.rating = rating;
		this.size = size;
		this.numberResults = numberResults;
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
