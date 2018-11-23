package ca.mcgill.ecse321.rideshare.tripController;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.mcgill.ecse321.rideshare.driverController.DriverService;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.Trip;
import ca.mcgill.ecse321.rideshare.passengerController.*;

@CrossOrigin
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
	public Trip addTripPassenger(@RequestBody Trip trip, @PathVariable String passengerId) {
		Passenger passenger = passengerService.getPassenger(passengerId);
		Set<Trip> existingTrips = passenger.getTrip();
		existingTrips.add(trip);
		passenger.setTrip(existingTrips);
		passengerService.updatePassenger(passengerId, passenger);
		if(trip.getIdentifier() == 0) {
			tripService.addTrip(trip);
		}		
		return trip;
		
	}

	@RequestMapping(method=RequestMethod.POST, value="/drivers/{driverId}/trips")
	public Trip addTripDriver(@RequestBody Trip trip, @PathVariable String driverId) {
		Driver driver = driverService.getDriver(driverId);
		int age = driver.getAge();
		int accountNumber = driver.getAccountNumber();
		double ranking = driver.getRanking();
		long tripCounter = driver.getTripCounter();
		trip.setDriver(new Driver("", "", age, "", "", "",
			"", driverId, true, accountNumber, ranking, tripCounter));
		tripService.addTrip(trip);
		return trip;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/passengers/{passengerId}/trips/{id}")
	public Trip updateTripPassenger(@RequestBody Trip trip, @PathVariable String passengerId, @PathVariable Long id) {
		tripService.updateTrip(id, trip);		
		return trip;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/drivers/{driverId}/trips/{id}")
	public Trip updateTripDriver(@RequestBody Trip trip, @PathVariable String driverId, @PathVariable Long id) {
		tripService.updateTrip(id,  trip);
		return trip;
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

