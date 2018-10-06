package ca.mcgill.ecse321.rideshare.model;

import java.util.Set;
import java.util.HashSet;

public class Trip {

public Trip() {
	
}
	
//This constructor has too many args. most of these arguments aren't neccessary when making a driver object
public Trip(String date, String pickUpLocation, String destination, //SpecificRating specificRating, 
			String pickUpTime, String arrivalTime, int availableSeats, boolean isComplete, double fare,
			Integer estimatedTripDuration, int driverRating, int passengerRating, int distance,
			Set<Passenger> passenger, Driver driver) {
		super();
//		this.specificRating = specificRating;
		this.date = date;
		this.pickUpLocation = pickUpLocation;
		this.destination = destination;
		this.pickUpTime = pickUpTime;
		this.arrivalTime = arrivalTime;
		this.availableSeats = availableSeats;
		this.isComplete = isComplete;
		this.fare = fare;
		this.estimatedTripDuration = estimatedTripDuration;
		this.driverRating = driverRating;
		this.passengerRating = passengerRating;
		this.distance = distance;
		this.passenger = passenger;
		this.driver = driver;
		
		this.tripId++; // Increment Id everytime a new trip instance is created
		// TODO: Make sure when I do list.add, this still works
	}



// association class with Rating
//SpecificRating specificRating;

public Trip(String pickUpLocation, String destination, String pickUpTime, int availableSeats, double fare,
		Driver driver, int tripId) {
	super();
	this.pickUpLocation = pickUpLocation;
	this.destination = destination;
	this.pickUpTime = pickUpTime;
	this.availableSeats = availableSeats;
	this.fare = fare;
	this.driver = driver;
	
	this.tripId = tripId;
	
	//HERE you can calculate the remaining fields like estimatedTripDuration etc, using the fields above
	//Also a unique id will be generated here, for now I'll put it in the constructor itself
	
}




private String date;

private static int tripId; // will be unique for each Trip
public int getTripId() {
	return this.tripId;
}

public void setDate(String value) {
   this.date = value;
}

public String getDate() {
   return this.date;
}

private String pickUpLocation;

public void setPickUpLocation(String value) {
   this.pickUpLocation = value;
}

public String getPickUpLocation() {
   return this.pickUpLocation;
}

private String destination;

public void setDestination(String value) {
   this.destination = value;
}

public String getDestination() {
   return this.destination;
}

private String pickUpTime;

public void setPickUpTime(String value) {
   this.pickUpTime = value;
}

public String getPickUpTime() {
   return this.pickUpTime;
}

private String arrivalTime;

public void setArrivalTime(String value) {
   this.arrivalTime = value;
}

public String getArrivalTime() {
   return this.arrivalTime;
}

private int availableSeats;

public void setAvailableSeats(int value) {
   this.availableSeats = value;
}

public int getAvailableSeats() {
   return this.availableSeats;
}

private boolean isComplete;

public void setIsComplete(boolean value) {
   this.isComplete = value;
}

public boolean getIsComplete() {
   return this.isComplete;
}

private double fare;

public void setFare(double value) {
   this.fare = value;
}

public double getFare() {
   return this.fare;
}

private Integer estimatedTripDuration;

public void setEstimatedTripDuration(Integer value) {
   this.estimatedTripDuration = value;
}

public Integer getEstimatedTripDuration() {
   return this.estimatedTripDuration;
}

private int driverRating;

public void setDriverRating(int value) {
   this.driverRating = value;
}

public int getDriverRating() {
   return this.driverRating;
}

private int passengerRating;

public void setPassengerRating(int value) {
   this.passengerRating = value;
}

public int getPassengerRating() {
   return this.passengerRating;
}

private int distance;

public void setDistance(int value) {
   this.distance = value;
}

public int getDistance() {
   return this.distance;
}

/**
 * <pre>
 *           0..*     0..*
 * Trip ------------------------- Passenger
 *           trip        &gt;       passenger
 * </pre>
 */
private Set<Passenger> passenger;

public Set<Passenger> getPassenger() {
   if (this.passenger == null) {
this.passenger = new HashSet<Passenger>();
   }
   return this.passenger;
}

/**
 * <pre>
 *           0..*     1..1
 * Trip ------------------------- Driver
 *           trip        &gt;       driver
 * </pre>
 */
private Driver driver;

public void setDriver(Driver value) {
   this.driver = value;
}

public Driver getDriver() {
   return this.driver;
}

}
