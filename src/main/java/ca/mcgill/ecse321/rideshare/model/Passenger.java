package ca.mcgill.ecse321.rideshare.model;

import java.util.Set;

import javax.persistence.Id;

import java.util.HashSet;

public class Passenger extends User {
	
	SpecificRating specificRating;
	
public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(String firstName, String lastName, int age, String email, String phoneNumber, String gender,
			String address, String userName, boolean isActive, String creditCardNumber) {
		super(firstName, lastName, age, email, phoneNumber, gender, address, userName, isActive);
		this.creditCardNumber = creditCardNumber;
		// TODO Auto-generated constructor stub
		// TODO: ADD PASSENGER RATING FOR SPECIFIC TRIP IN CONSTRUCTOR
	}

	@Id
private String creditCardNumber;

public void setCreditCardNumber(String value) {
   this.creditCardNumber = value;
}

public String getCreditCardNumber() {
   return this.creditCardNumber;
}

/**
 * <pre>
 *           0..*     0..*
 * Passenger ------------------------- Trip
 *           passenger        &lt;       trip
 * </pre>
 */
private Set<Trip> trip;

public Set<Trip> getTrip() {
   if (this.trip == null) {
this.trip = new HashSet<Trip>();
   }
   return this.trip;
}

}
