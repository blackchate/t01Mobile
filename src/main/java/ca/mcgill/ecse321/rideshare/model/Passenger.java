package ca.mcgill.ecse321.rideshare.model;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.HashSet;


@Table(name = "passenger_info")
public class Passenger extends User {
	
	
	@Id
	@GeneratedValue(generator = "passenger_generator")
	@SequenceGenerator(
			name = "passenger_generator",
			sequenceName = "passenger_sequence",
			initialValue  = 1000
			)
	private Long id;
	
//	SpecificRating specificRating;
	
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

private String creditCardNumber;
private Set<Trip> trip;

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


public Set<Trip> getTrip() {
   if (this.trip == null) {
this.trip = new HashSet<Trip>();
   }
   return this.trip;
}

}
