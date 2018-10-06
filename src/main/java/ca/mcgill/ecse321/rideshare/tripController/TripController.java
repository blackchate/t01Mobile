package ca.mcgill.ecse321.rideshare.tripController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ca.mcgill.ecse321.rideshare.model.Trip;

@RestController
public class TripController {
	
	//specify service
	@Autowired
	private TripService tripService;
	
	//mapping
	@RequestMapping("/trips")
	public List<Trip> getAllTrips() {
		return tripService.getAllTrips();
	}
	
}