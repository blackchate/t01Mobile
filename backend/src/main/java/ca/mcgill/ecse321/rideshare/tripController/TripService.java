package ca.mcgill.ecse321.rideshare.tripController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.Trip;
import ca.mcgill.ecse321.rideshare.repo.TripRepository;
import ca.mcgill.ecse321.rideshare.repo.PassengerRepository;

@Service
@Transactional
public class TripService {

	@Autowired 
	private TripRepository tripRepo;
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Transactional
	public List<Trip> getAllTrips() {
		List<Trip> trips = new ArrayList<>();
		tripRepo.findAll().forEach(trips::add);
		return trips;
	}
	
	@Transactional
	public List<Trip> getAllTripsByPassenger(String username) {
		List<Trip> trips = new ArrayList<>();
		//Passenger passenger = passengerRepo.findByUserName(username);
		//passenger.getTrip().forEach(trips::add);
		tripRepo.findByPassengersUserName(username).forEach(trips::add);
		
		return trips;
	}
	
	@Transactional
	public List<Trip> getAllTripsByDriver(String username) {
		List<Trip> trips = new ArrayList<>();
		tripRepo.findByDriverUserName(username).forEach(trips::add);
		
		return trips;
	}
	
	@Transactional
	public Optional<Trip> getTrip(Long id) {
		return tripRepo.findByIdentifier(id);
	}
	
	@Transactional
	public void addTrip(Trip trip) {
		tripRepo.save(trip);
	}
	
	@Transactional
	public void updateTrip(Long id, Trip trip) {
		tripRepo.save(trip);
	}
	
	@Transactional
	public Optional<Trip> deleteTrip(Long id) {
		Optional<Trip> tripToDelete = tripRepo.findByIdentifier(id);
		tripRepo.deleteByIdentifier(id);
		return tripToDelete;
	}
}
