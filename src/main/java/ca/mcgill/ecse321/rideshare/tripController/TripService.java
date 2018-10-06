

package ca.mcgill.ecse321.rideshare.tripController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.Trip;
import ca.mcgill.ecse321.rideshare.model.User;


@Service
public class TripService {
	
	
	Driver driver1 = new Driver("Derek", "McCarty", 34, "derek@hotmail.com", "5147895670", "Man",
			"3525 St Dennis", "Derek22", true, 2009028) ;
	
	Car car1 = new Car(6637728, driver1);
	
	private List<Trip> trips = new ArrayList<>(Arrays.asList(
			new Trip("25/05/2016", "2840 St Barbeu", "London", 7, 25.90, driver1,278),
			new Trip("25/05/2017", "3040 St Dennis", "Tokyo", 7, 35.90, driver1,891),
			new Trip("25/05/2018", "4445 St Durocher", "New York", 7, 25.90, driver1,121 )
			));
	
	
	public List<Trip> getAllTrips() {
		return trips;
	}
	
	
	
	public Trip getTrip(int id) {
		return trips.stream().filter(u -> u.getTripId() == id).findFirst().get();
	}
	
	public void addTrip(Trip trip) {
		trips.add(trip);
	}
	
	
	
}


