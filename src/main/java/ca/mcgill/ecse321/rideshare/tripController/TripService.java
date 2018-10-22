package ca.mcgill.ecse321.rideshare.tripController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.Trip;
import ca.mcgill.ecse321.rideshare.repo.TripRepository;
import ca.mcgill.ecse321.rideshare.repo.PassengerRepository;

@Service
public class TripService {

	@Autowired 
	private TripRepository tripRepo;
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	public List<Trip> getAllTrips() {
		List<Trip> trips = new ArrayList<>();
		tripRepo.findAll().forEach(trips::add);
		return trips;
	}
	
	public List<Trip> getAllTripsByPassenger(String username) {
		List<Trip> trips = new ArrayList<>();
		//Passenger passenger = passengerRepo.findByUserName(username);
		//passenger.getTrip().forEach(trips::add);
		tripRepo.findByPassengersUserName(username).forEach(trips::add);
		
		return trips;
	}
	
	public List<Trip> getAllTripsByDriver(String username) {
		List<Trip> trips = new ArrayList<>();
		tripRepo.findByDriverUserName(username).forEach(trips::add);
		
		return trips;
	}
	
	public Optional<Trip> getTrip(Long id) {
		return tripRepo.findByIdentifier(id);
	}
	
	public void addTrip(Trip trip) {
		tripRepo.save(trip);
	}
	
	public void updateTrip(Long id, Trip trip) {
		tripRepo.save(trip);
	}
	
	public Optional<Trip> deleteTrip(Long id) {
		Optional<Trip> tripToDelete = tripRepo.findByIdentifier(id);
		tripRepo.deleteByIdentifier(id);
		return tripToDelete;
	}
}
