package ca.mcgill.ecse321.rideshare.tripController;

import static org.assertj.core.api.Assertions.setAllowComparingPrivateFields;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.mcgill.ecse321.rideshare.driverController.DriverService;
import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.Trip;
import ca.mcgill.ecse321.rideshare.passengerController.*;

@RestController
public class TripController {
	
	@Autowired
	private TripService tripService;
	
	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private DriverService driverService;
	
	@RequestMapping("/trips")
	public List<Trip> getAllTrips(){
		return tripService.getAllTrips();
	}
	
	@RequestMapping("/passengers/{id}/trips")
	public List<Trip> getAllTripsByPassenger(@PathVariable String id) {
		return tripService.getAllTripsByPassenger(id);
	}
	
	@RequestMapping("/drivers/{id}/trips")
	public List<Trip> getAllTripsByDriver(@PathVariable String id) {
		return tripService.getAllTripsByDriver(id);
	}
	
	@RequestMapping("/passengers/{passengerId}/trips/{id}")
	public Optional<Trip> getTripPassenger(@PathVariable Long id) {
		return tripService.getTrip(id);
	}

	@RequestMapping("/drivers/{driverId}/trips/{id}")
	public Optional<Trip> getTripDriver(@PathVariable Long id) {
		return tripService.getTrip(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/passengers/{passengerId}/trips")
	public void addTripPassenger(@RequestBody Trip trip, @PathVariable String passengerId) {
		Passenger passenger = passengerService.getPassenger(passengerId);
		//Set<Trip> passengerTrips = passenger.getTrip();
		//passengerTrips.add(trip);
		//passenger.setTrip(passengerTrips);
		//Set<Passenger> tripPassengers = trip.getPassenger();
		//int age = passenger.getAge();
		/*tripPassengers.add(new Passenger("", "", age, "", "", "", "", passengerId, true, "", new HashSet<Trip>()  {{
				add(trip); 
		}}));
		trip.setPassenger(tripPassengers);*/

		passenger.setTrip(new HashSet<Trip>() {{
			add(trip);
		}});
		
		/*int age = passenger.getAge();
		trip.setPassenger(new HashSet<Passenger>() {{
			add(new Passenger("","", age, "","", "","", passengerId, true, "", new HashSet<Trip> (){{
			add(trip);
			}}));
		}});*/
		 /*publisherRepository.save(new HashSet<Publisher>() {{
	            add(new Publisher("Publisher A", new HashSet<Book>() {{
	                add(bookA);
	                add(bookB);
	            }}));

	            String firstName, String lastName, int age, String email, String phoneNumber, String gender,
				String address, String userName, boolean isActive, String creditCardNumber, Set<Trip> trips*/
		//int age = 0;
		
		tripService.addTrip(trip);
	}

	@RequestMapping(method=RequestMethod.POST, value="/drivers/{driverId}/trips")
	public void addTripDriver(@RequestBody Trip trip, @PathVariable String driverId) {
		Driver driver = driverService.getDriver(driverId);
		int age = driver.getAge();
		int accountNumber = driver.getAccountNumber();
		Car car =  driver.getCar();
		trip.setDriver(new Driver("", "", age, "", "", "",
			"", driverId, true, accountNumber, car));
		tripService.addTrip(trip);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/passengers/{passengerId}/trips/{id}")
	public void updateTripPassenger(@RequestBody Trip trip, @PathVariable String passengerId, @PathVariable Long id) {
		//Passenger passenger = passengerService.getPassenger(passengerId);
		//trip.setPassenger(value);
		//trip.setPassenger(new HashSet<Passenger>() {{
		//	add(passenger);
		//}});
		tripService.updateTrip(id, trip);		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/drivers/{driverId}/trips/{id}")
	public void updateTripDriver(@RequestBody Trip trip, @PathVariable String driverId, @PathVariable Long id) {
		tripService.updateTrip(id,  trip);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/passengers/{passengerId}/trips/{id}")
	public void deleteTripPassenger(@PathVariable Long id) {
		tripService.deleteTrip(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/drivers/{driverId}/trips/{id}")
	public void deleteTripDriver(@PathVariable Long id) {
		tripService.deleteTrip(id);
	}


}	

