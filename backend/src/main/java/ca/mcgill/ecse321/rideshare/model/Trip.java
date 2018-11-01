package ca.mcgill.ecse321.rideshare.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;

@Entity
@Table(name = "trip")
public class Trip implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "trip_id")
	private long identifier;
	//When you create a new trip, this is null
	
	@Column(name = "date")
	private String date;
	

	@Column(name = "pickUpLocation")
	private String pickUpLocation;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "pickUpTime")
	private String pickUpTime;
	
	@Column(name = "arrivalTime")
	private String arrivalTime;
	
	@Column(name = "availableSeats")
	private int availableSeats;
	
	@Column(name = "status")
	private boolean isComplete;
	
	@Column(name = "fare")
	private double fare;

	@Column(name = "estimatedTripDuration")
	private Integer estimatedTripDuration;
	
	@Column(name = "driverRating")
	private int driverRating;
	
	@Column(name = "passengerRating")
	private int passengerRating;
	
	@Column(name = "distance")
	private int distance;
	
	/*@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "trips")*/
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.REMOVE},
			mappedBy = "trips")
	
	private Set<Passenger> passengers;
	
	/* @ManyToOne(fetch = FetchType.LAZY)
	 private Set<Passenger> passengers;*/
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Driver driver;


protected Trip() {
	
}
	
/*public Trip(String date, String pickUpLocation, String destination, //SpecificRating specificRating, 
		String pickUpTime, String arrivalTime, int availableSeats, boolean isComplete, double fare,
		Integer estimatedTripDuration, int driverRating, int passengerRating, int distance, Driver driver) {
	super();
//	this.specificRating = specificRating;
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
	this.driver = driver;
	//this.identifier = identifier;
}*/

public Trip(String date, String pickUpLocation, String destination, //SpecificRating specificRating, 
		String pickUpTime, String arrivalTime, int availableSeats, boolean isComplete, double fare,
		Integer estimatedTripDuration, int driverRating, int passengerRating, int distance, Driver driver,long identifier, Set<Passenger> passengers) {
	super();
//	this.specificRating = specificRating;
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
	this.driver = driver;
	this.identifier = identifier;
	this.passengers = passengers;
}

/*public Trip(String date, String pickUpLocation, String destination, //SpecificRating specificRating, 
			String pickUpTime, String arrivalTime, int availableSeats, boolean isComplete, double fare,
			Integer estimatedTripDuration, int driverRating, int passengerRating, int distance,
			Set<Passenger> passengers, Driver driver) {
		//super();
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
		this.passengers = passengers;
		this.driver = driver;
		this.identifier = identifier;
	}*/

// association class with Rating
//SpecificRating specificRating;

public void setIdentifier(long value) {
	this.identifier = value;
}

public long getIdentifier() {
	return this.identifier;
}

public void setDate(String value) {
   this.date = value;
}

public String getDate() {
   return this.date;
}

public void setPickUpLocation(String value) {
   this.pickUpLocation = value;
}

public String getPickUpLocation() {
   return this.pickUpLocation;
}

public void setDestination(String value) {
   this.destination = value;
}

public String getDestination() {
   return this.destination;
}

public void setPickUpTime(String value) {
   this.pickUpTime = value;
}

public String getPickUpTime() {
   return this.pickUpTime;
}

public void setArrivalTime(String value) {
   this.arrivalTime = value;
}

public String getArrivalTime() {
   return this.arrivalTime;
}

public void setAvailableSeats(int value) {
   this.availableSeats = value;
}

public int getAvailableSeats() {
   return this.availableSeats;
}

public void setIsComplete(boolean value) {
   this.isComplete = value;
}

public boolean getIsComplete() {
   return this.isComplete;
}

public void setFare(double value) {
   this.fare = value;
}

public double getFare() {
   return this.fare;
}

public void setEstimatedTripDuration(Integer value) {
   this.estimatedTripDuration = value;
}

public Integer getEstimatedTripDuration() {
   return this.estimatedTripDuration;
}

public void setDriverRating(int value) {
   this.driverRating = value;
}

public int getDriverRating() {
   return this.driverRating;
}

public void setPassengerRating(int value) {
   this.passengerRating = value;
}

public int getPassengerRating() {
   return this.passengerRating;
}

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
@JsonIgnore
public Set<Passenger> getPassenger() {
   if (this.passengers == null) {
this.passengers = new HashSet<Passenger>();
   }
   return this.passengers;
}

public void setPassenger(Set<Passenger> value) {
	this.passengers = value;
}

/**
 * <pre>
 *           0..*     1..1
 * Trip ------------------------- Driver
 *           trip        &gt;       driver
 * </pre>
 */

public void setDriver(Driver driver) {
   this.driver = driver;
}

public Driver getDriver() {
   return this.driver;
}

}
