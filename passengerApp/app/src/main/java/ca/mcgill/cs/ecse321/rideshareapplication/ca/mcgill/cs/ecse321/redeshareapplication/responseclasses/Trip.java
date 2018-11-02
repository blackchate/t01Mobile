package ca.mcgill.cs.ecse321.rideshareapplication.ca.mcgill.cs.ecse321.redeshareapplication.responseclasses;

import java.util.Set;

public class Trip {
    private long identifier;
    private String date;
    private String pickUpLocation;
    private String destination;
    private String pickUpTime;
    private String arrivalTime;
    private int availableSeats;
    private boolean isComplete;
    private double fare;
    private Integer estimatedTripDuration;
    private int driverRating;
    private int passengerRating;
    private int distance;
    Driver driver;
    Set<Passenger> passengers;



    public long getIdentifier() {
        return identifier;
    }

    public String getDate() {
        return date;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getDestination() {
        return destination;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public double getFare() {
        return fare;
    }

    public Integer getEstimatedTripDuration() {
        return estimatedTripDuration;
    }

    public int getDriverRating() {
        return driverRating;
    }

    public int getPassengerRating() {
        return passengerRating;
    }

    public int getDistance() {
        return distance;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setEstimatedTripDuration(Integer estimatedTripDuration) {
        this.estimatedTripDuration = estimatedTripDuration;
    }

    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }

    public void setPassengerRating(int passengerRating) {
        this.passengerRating = passengerRating;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
