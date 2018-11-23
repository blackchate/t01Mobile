package ca.mcgill.ecse321.rideshare.adminOperationsController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import ca.mcgill.ecse321.rideshare.driverController.DriverService;
import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.Trip;
import ca.mcgill.ecse321.rideshare.passengerController.PassengerService;
import ca.mcgill.ecse321.rideshare.tripController.TripService;
@CrossOrigin

@Service
public class AdminOperationsService {
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private TripService tripService;
	
	
	
	// TEST DATA
	

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	// ENDPOINTS
	
	
	
	
	// TRIPS
	
	public List<Trip> getAllTrips() {
		return tripService.getAllTrips();
	}

	public String addNewtrip(Trip trip) {
		return "YOU ADDED A NEW TRIP TO DATABASE";
	}

	public Trip updateTrip(long identifier, Trip trip) {
		return null;
	}
	
	// returns the trip we removed
	public Trip deleteTrip(long identifier) {
		return null;
	}

	public List<Trip> getAllActiveTrips() {
		List<Trip> activeTrips = new ArrayList<>();
		List<Trip> trips = new ArrayList<>();
		trips = tripService.getAllTrips();
		for (int i = 0; i < trips.size(); i++) {
			Trip currentTrip = trips.get(i);
			if (currentTrip.getOngoing() == true && currentTrip.getIsComplete() != true){
				activeTrips.add(currentTrip);
			}
		}
		return activeTrips;
	}
	
	// PASSENGERS
	
	public List<Passenger> getAllPassengers() {
		return passengerService.getAllPassengers();
	}
	
	public List<Passenger> getAllActivePassengers() {
		List<Passenger> activePassengers = new ArrayList<>();
		List<Passenger> passengers = new ArrayList<>();
		passengers = passengerService.getAllPassengers();
		for (int i = 0; i < passengers.size(); i++) {
			Passenger currentPassenger = passengers.get(i);
			if (currentPassenger.isActive() == true ){
				activePassengers.add(currentPassenger);
			}
		}
		return activePassengers;
	}
	
	//TODO
	//public getActivePassengerStatus();
	
	

	
	// DRIVERS
	
	public List<Driver> getAllDrivers(){
		return driverService.getAllDrivers();
	}
	
	public List<Driver> getAllActiveDrivers(){
		List<Driver> activeDrivers = new ArrayList<>();
		List<Driver> drivers = new ArrayList<>();
		drivers = driverService.getAllDrivers();
		for (int i = 0; i < drivers.size(); i++) {
			Driver currentDriver = drivers.get(i);
			if (currentDriver.isActive() ==  true) {
				activeDrivers.add(currentDriver);
			}
		}
		return activeDrivers;
	}
}

