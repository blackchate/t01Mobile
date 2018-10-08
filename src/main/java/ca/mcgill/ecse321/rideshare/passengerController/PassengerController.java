package ca.mcgill.ecse321.rideshare.passengerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ca.mcgill.ecse321.rideshare.model.Passenger;

@RestController
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;
	
	@RequestMapping("/passengers")
	public List<Passenger> getAllPassengers() {
		return passengerService.getAllPassengers();
	}

	@RequestMapping("/passengers/{username}")
	public Passenger getPassenger(@PathVariable String username) {
		return passengerService.getPassenger(username);
		
	}

	@RequestMapping(method=RequestMethod.POST, value = "/passengers")
	public String addPassenger(@RequestBody Passenger passenger) {
		passengerService.addPassenger(passenger);
		return "YOU ADDED A NEW PASSENGER";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/passengers/{username}")
	public Passenger updatePassenger(@RequestBody Passenger passenger, @PathVariable String username) {
		Passenger oldPassenger = passengerService.getPassenger(username); // null if no passenger with that username yet
		passengerService.updatePassenger(username, passenger);
		return passenger;
	}

	@RequestMapping(method=RequestMethod.DELETE, value = "/passengers/{username}")
	public String deletePassenger(@PathVariable String username) { // TODO: if There's no passenger to remove, return custom message
		Passenger returnedValue = passengerService.deletePassenger(username);
		if(returnedValue == null) {
			return "THERE IS NO PASSENGER WITH THAT USERNAME TO DELETE";
		}
		return "YOU DELETED A PASSENGER";
	}
	
}