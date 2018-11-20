package ca.mcgill.ecse321.rideshare.adminOperationsController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.rideshare.driverController.DriverService;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.Trip;
import ca.mcgill.ecse321.rideshare.passengerController.PassengerService;

@CrossOrigin
@RestController

public class AdminOperationsController {
	/*@Autowired
	private AdminOperationsService adminOpService;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private PassengerService passengerService;
	
	// @RequestMapping("/admin/operations")
	// return list of active trips, users and passengers
	// reutrn top drivers and passengers
	
	/*@RequestMapping("/admin/operations/trips")
	public List<Trip> getAllTrips() {
		return adminOpService.getAllTrips();
	}
	
	// TODO: getTrip(int id)
	
	@RequestMapping(method=RequestMethod.POST, value = "/admin/operations/trips")
	// handle uniqueness of id in front end?
	public String addTrip(@RequestBody Trip trip) {
		adminOpService.addNewtrip(trip); // TODO: take care of ID here
		return "YOU POSTED A NEW TRIP";
	}
	
	@RequestMapping("/admin/operations/trips/active")
	public List<Trip> getActiveTrips() {
		return adminOpService.getAllActiveTrips();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/admin/operations/trips/{identifier}")
	public String updateTrip(@RequestBody Trip trip, @PathVariable long identifier) {
		if(adminOpService.updateTrip(identifier, trip) == null) {
			return "TRIP COULDN'T BE UPDATED AND HENCE DOESN'T EXISTS";
		}
		else {
			adminOpService.updateTrip(identifier, trip);
			return "YOU UPDATED A TRIP";
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/admin/operations/trips/{identifier}")
	public Trip deleteTrip(@PathVariable long identifier) {
		return adminOpService.deleteTrip(identifier);
	}
	
	
	// USERS END POINTS
	
	
	//@RequestMapping("/users")
	//public List<User> getAllUsers() {
	//	return adminOpService.getAllUsers();
	//}
	
	//@RequestMapping("/users/active")
	//public List<User> getAllActiveUsers() {
	//	return adminOpService.getAllActiveUsers();
	//}
	
	// active drivers and passengers endpoints
	//@RequestMapping("/drivers/active")
	//public List<Driver> getActiveDrivers() {
//		return driverService.getActiveDrivers();
	//}
	
	@RequestMapping("/passengers/active")
	public List<Passenger> getActivePassengers() {
		return passengerService.getActivePassengers();
	}*/
	
}
