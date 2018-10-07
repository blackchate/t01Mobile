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
	
	/*
	Lets say the user has clicked "show available trips" button. You need to present him 
	 a NICE page(front end) with trip data. But first you need the trip data. To do that you use the back end, where data 
	 is stored. You go to localhost/trips and access data for all trips. Now that you have the data present
	 this data to him on the front end.
	*/
	//mapping
	@RequestMapping("/trips")
	public List<Trip> getAllTrips() {
		return tripService.getAllTrips();
	}
	
}