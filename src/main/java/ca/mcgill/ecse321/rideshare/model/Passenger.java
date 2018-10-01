package ca.mcgill.ecse321.rideshare.model;

import java.util.Set;
import java.util.HashSet;

public class Passenger extends User {
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
