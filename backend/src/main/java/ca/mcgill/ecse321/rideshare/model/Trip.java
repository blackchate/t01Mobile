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
	private Long identifier;
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
	private Integer availableSeats;
	
	@Column(name = "arrivalStatus")
	private Boolean isComplete;
	
	@Column(name = "departureStatus")
	private Boolean ongoing;
	
	@Column(name = "fare")
	private Double fare;

	@Column(name = "estimatedTripDuration")
	private String estimatedTripDuration;
	
	@Column(name = "driverRating")
	private Integer driverRating;
	
	@Column(name = "passengerRating")
	private Integer passengerRating;
	
	@Column(name = "distance")
	private Integer distance;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			mappedBy = "trips")
	
	private Set<Passenger> passenger;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Driver driver;


protected Trip() {
	
}

public Trip(String date, String pickUpLocation, String destination, //SpecificRating specificRating, 
		String pickUpTime, String arrivalTime, Integer availableSeats, Boolean isComplete, Boolean ongoing, Double fare,
		String estimatedTripDuration, Integer driverRating, Integer passengerRating, Integer distance, Driver driver, Long identifier, Set<Passenger> passenger) {
	super();
//	this.specificRating = specificRating;
	this.date = date;
	this.pickUpLocation = pickUpLocation;
	this.destination = destination;
	this.pickUpTime = pickUpTime;
	this.arrivalTime = arrivalTime;
	this.availableSeats = availableSeats;
	this.isComplete = isComplete;
	this.ongoing = ongoing;
	this.fare = fare;
	this.estimatedTripDuration = estimatedTripDuration;
	this.driverRating = driverRating;
	this.passengerRating = passengerRating;
	this.distance = distance;
	this.driver = driver;
	this.identifier = identifier;
	this.passenger = passenger;
}

// association class with Rating
//SpecificRating specificRating;

public void setIdentifier(long value) {
	this.identifier = value;
}

public Long getIdentifier() {
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

public void setAvailableSeats(Integer value) {
   this.availableSeats = value;
}

public Integer getAvailableSeats() {
   return this.availableSeats;
}

public void setIsComplete(boolean value) {
   this.isComplete = value;
}

public Boolean getIsComplete() {
   return this.isComplete;
}

public void setOngoing(Boolean value) {
	   this.ongoing = value;
}

public Boolean getOngoing() {
	   return this.ongoing;
	}

public void setFare(Double value) {
   this.fare = value;
}

public Double getFare() {
   return this.fare;
}

public void setEstimatedTripDuration(String value) {
   this.estimatedTripDuration = value;
}

public String getEstimatedTripDuration() {
   return this.estimatedTripDuration;
}

public void setDriverRating(int value) {
   this.driverRating = value;
}

public Integer getDriverRating() {
   return this.driverRating;
}

public void setPassengerRating(Integer value) {
   this.passengerRating = value;
}

public Integer getPassengerRating() {
   return this.passengerRating;
}

public void setDistance(Integer value) {
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
   if (this.passenger == null) {
this.passenger = new HashSet<Passenger>();
   }
   return this.passenger;
}

public void setPassenger(Set<Passenger> value) {
	this.passenger = value;
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
