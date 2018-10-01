package ca.mcgill.ecse321.rideshare.model;

import java.util.Set;
import java.util.HashSet;

public class Trip {
private String date;

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

public boolean isIsComplete() {
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
