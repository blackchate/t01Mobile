package ca.mcgill.ecse321.rideshare.userController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Trip;
import ca.mcgill.ecse321.rideshare.model.User;


@Service
public class TripService {
	
	Car car1 = new Car(1289930);
	Driver driver1 = new Driver("Derek", "McCarty", 35, "derek@hotmail.com", "5156703297", "male",
			"3340 St Dennis", "Derekky24", 21567, car1);
	
	private List<Trip> trips = new ArrayList<>(Arrays.asList(
			new Trip("25/05/2016", "2840 St Barbeu", "London", 7, 25.90, driver1),
			new Trip("25/05/2017", "3040 St Dennis", "Tokyo", 7, 35.90, driver1),
			new Trip("25/05/2018", "4445 St Durocher", "New York", 7, 25.90, driver1 )
			));
	
	
	public List<Trip> getAllUsers() {
		return trips;
	}
	
	public User getTrip(String username) {
		return trips.stream().filter(u -> u.getUserName().equals(username)).findFirst().get();
	}
	
	public void addTrip(Trip trip) {
		trips.add(trip);
	}
	
	public void deleteUser(String username) {
		users.removeIf(u -> u.getUserName().equals(username));
	}
}
