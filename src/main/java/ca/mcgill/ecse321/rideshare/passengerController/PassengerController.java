/*package ca.mcgill.ecse321.rideshare.passengerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}*/