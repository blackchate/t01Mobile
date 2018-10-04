package ca.mcgill.ecse321.rideshare.model;

public class SpecificRating {
	private int rating;
	Trip trip;
	Passenger passenger;

	public SpecificRating(int rating) {
		super();
		this.rating = rating;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
