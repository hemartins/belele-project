package pt.belele.project.controllers.util;

public class H2H {

	private Double rating;
	private Integer size;

	public H2H(Double rating, Integer size) {
		this.rating = rating;
		this.size = size;
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

}
