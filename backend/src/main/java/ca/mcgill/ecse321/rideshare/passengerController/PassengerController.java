package ca.mcgill.ecse321.rideshare.passengerController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ca.mcgill.ecse321.rideshare.model.Passenger;

@CrossOrigin
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
	public void addPassenger(@RequestBody Passenger passenger) {
		passengerService.addPassenger(passenger);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/passengers/{username}")
	public Passenger updatePassenger(@RequestBody Passenger passenger, @PathVariable String username) {
		passengerService.updatePassenger(username, passenger);
		return passenger;
	}

	@RequestMapping(method=RequestMethod.DELETE, value = "/passengers/{username}")
	public void deletePassenger(@PathVariable String username) { 
		passengerService.deletePassenger(username);
	}
	
}
