package ca.mcgill.ecse321.rideshare.adminOperationsController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.driverController.DriverService;
import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.Trip;
import ca.mcgill.ecse321.rideshare.passengerController.PassengerService;

@Service
public class AdminOperationsService {
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private PassengerService passengerService;
	
	
	
	// TEST DATA
	

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	// ENDPOINTS
	
	
	
	
	// TRIPS
	
	public List<Trip> getAllTrips() {
		return null;
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
		return null;
	}
}

