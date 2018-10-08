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
import ca.mcgill.ecse321.rideshare.model.User;
import ca.mcgill.ecse321.rideshare.passengerController.PassengerService;

@Service
public class AdminOperationsService {
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private PassengerService passengerService;
	
	
	Car car1 = new Car();
	Driver driver1 = new Driver("Driver1", "Lassdfadtname2", 55, "test@test.com", "555555", "Earthling", "Earth",
			"another username", false, 66, car1);
	Set<Passenger> passengerSet = new HashSet<Passenger>();

	// only first driver is active

	private List<Trip> allTrips = new ArrayList<>(Arrays.asList(
			new Trip("TEST", "PickupLocation", "Destination", "pickUpTime", "arrival Time", 5, true, 55.5, (Integer)5, 3, 555, 10,
			passengerSet, driver1)
			));
	
	// List of Drivers
	private List<Driver> drivers = new ArrayList<>(Arrays.asList( // new ArrayList so that drivers list is mutable
			new Driver("Driver1", "ddsdsds", 2, "donat@test.com", "01233445", "Alien",
					"Mars", "myUsername", true, 55, car1),
			new Driver("Driver2", "Lassdfadtname2", 55, "test@test.com", "555555", "Earthling",
					"Earth", "another username", true, 66, car1),
			new Driver("Driver3", "ssssssss", 901, "earth@test.com", "01233445", "Earthling",
					"Pacific Ocean", "sdfd", false, 77, car1)
			));
	
	// List of Passengers
	private List<Passenger> passengers = new ArrayList<>(Arrays.asList(
			new Passenger("Passenger1", "ddsdsds", 2, "donat@test.com", "01233445", "Alien",
					"Mars", "myUsername", false, "55555555555"),
			new Passenger("Passenger2", "Lassdfadtname2", 55, "test@test.com", "555555", "Earthling",
					"Earth", "another username", false, "7777777777777"),
			new Passenger("Passenger3", "ssssssss", 901, "earth@test.com", "01233445", "Earthling",
					"Pacific Ocean", "sdfd", true, "8888888888888")
			));
	
	// List of Users
	private List<User> users = new ArrayList<>(Arrays.asList( // new ArrayList so that drivers list is mutable
	new Driver("User Driver 1", "ddsdsds", 2, "donat@test.com", "01233445", "Alien", "Mars", "myUsername", true, 66,
			car1),
	new Driver("User Driver 2", "Lassdfadtname2", 55, "test@test.com", "555555", "Earthling", "Earth",
			"another username", false, 66, car1),
	new Passenger("User Passenger 3", "ssssssss", 901, "earth@test.com", "01233445", "Earthling", "Pacific Ocean",
			"sdfd", false, "creditCardInfo")));
	
	
	// METHODS
	
	
	// USERS
	
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<>();
		allUsers.addAll(driverService.getAllDrivers());
		allUsers.addAll(passengerService.getAllPassengers());
		allUsers.addAll(users);
		return allUsers;
	}
	
	public List<User> getAllActiveUsers() {
		List<User> activeUsers = new ArrayList<>();
		for(User u : users) {
			if(u.isActive()) {
				activeUsers.add(u);
			}
		}
		for(Driver d : drivers) {
			if(d.isActive()) {
				activeUsers.add(d);
			}
		}
		for(Passenger p : passengers) {
			if(p.isActive()) {
				activeUsers.add(p);
			}
		}
		return activeUsers;
	}
	
//	public List<User> getAllUsers() {
//		List<User> allUsers = new ArrayList<>();
//		for(int i = 0; i < users.size(); i++) {
//			allUsers.add(users.get(i));
//		}
//		for(int i = 0; i < drivers.size(); i++) {
//			allUsers.add(drivers.get(i));
//		}
//		for(int i = 0; i < passengers.size(); i++) {
//			allUsers.add(passengers.get(i));
//		}
//		return allUsers;
//	}

//	public List<User> getAllActiveUsers() {
//		List<User> activeUsers = null;
//		for (int i = 0; i < users.size(); i++) {
//			if (users.get(i).isActive()) {
//				activeUsers.add(users.get(i));
//			}
//		}
//		return activeUsers;
//	}

	// post active user maybe?

	
	// TRIPS
	
	
	// post active trip
	public List<Trip> getAllTrips() {
		return allTrips;
	}

	public String addNewtrip(Trip trip) {
		allTrips.add(trip);
		return "YOU ADDED A NEW TRIP TO DATABASE";
	}

	// TODO: Put/Updat trip
	// TODO: Delete trip

	// public String deleteTrip() { // what do we pass in? Trip ID?
	// }

	public List<Trip> getAllActiveTrips() {
		List<Trip> activeTrips = null;
		for (int i = 0; i < allTrips.size(); i++) {
			if (!allTrips.get(i).getIsComplete()) { // if trip is not complete then it's active. Return all of them
				activeTrips.add(allTrips.get(i));
			}
		}
		return activeTrips;
	}
	
	// TODO: set a trip to isComplete == true? DO we do this here on just use method?
	public String setTripToCompleted(Trip trip) {
		trip.setIsComplete(true);
		return "YOU SET A TRIP TO COMPLETED";
	}
}

// DON'T KNOW HOW
