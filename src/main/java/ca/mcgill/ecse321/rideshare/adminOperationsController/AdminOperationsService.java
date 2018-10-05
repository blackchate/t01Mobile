package ca.mcgill.ecse321.rideshare.adminOperationsController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.Trip;
import ca.mcgill.ecse321.rideshare.model.User;

@Service
public class AdminOperationsService {
	Car car1 = new Car();
	Driver driver1 = new Driver("Driver1", "Lassdfadtname2", 55, "test@test.com", "555555", "Earthling", "Earth",
			"another username", false, 66, car1);
	Set<Passenger> passengerSet = new HashSet<Passenger>();

	// only first driver is active
	private List<User> allUsers = new ArrayList<>(Arrays.asList( // new ArrayList so that drivers list is mutable
			new Driver("Driver1", "ddsdsds", 2, "donat@test.com", "01233445", "Alien", "Mars", "myUsername", true, 66,
					car1),
			new Driver("Driver1", "Lassdfadtname2", 55, "test@test.com", "555555", "Earthling", "Earth",
					"another username", false, 66, car1),
			new Passenger("Driver3", "ssssssss", 901, "earth@test.com", "01233445", "Earthling", "Pacific Ocean",
					"sdfd", false, "creditCardInfo")));

	private List<Trip> allTrips = new ArrayList<>(Arrays.asList(
			new Trip("TEST", "PickupLocation", "Destination", "pickUpTime", "arrival Time", 5, false, 55.5, (Integer)5, 3, 555, 10,
			passengerSet, driver1)
			));

	public List<User> getAllActiveUsers() {
		List<User> activeUsers = null;
		for (int i = 0; i < allUsers.size(); i++) {
			if (allUsers.get(i).isActice()) {
				activeUsers.add(allUsers.get(i));
			}
		}
		return activeUsers;
	}

	// post active user maybe?

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
