package ca.mcgill.ecse321.rideshare.passengerController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.PostRemove;
import javax.persistence.PreRemove;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.Trip;
import ca.mcgill.ecse321.rideshare.repo.PassengerRepository;
import ca.mcgill.ecse321.rideshare.repo.TripRepository;

@Service
@Transactional
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepo;

	@Autowired
	private TripRepository tripRepo;
	
	@Transactional
	public List<Passenger> getAllPassengers() {
		List<Passenger> passengers = new ArrayList<>();
		passengerRepo.findAll().forEach(passengers::add);
		return passengers;
	}
	
	@Transactional
	public Passenger getPassenger(String username) {
		return passengerRepo.findByUserName(username);
		}
	
	@Transactional
	public void addPassenger(Passenger passenger) {
		passenger.setRanking(1.0);
		passenger.setTripCounter((long) 0);
		passengerRepo.save(passenger);
	}
	
	@Transactional
	public void updatePassenger(String username, Passenger passenger) {
		passengerRepo.save(passenger);
	}
	
	@Transactional
	public Passenger deletePassenger(String username) {
		Passenger passengerToDelete = passengerRepo.findByUserName(username);
		passengerToDelete.getTrip().removeAll(passengerToDelete.getTrip());
		passengerRepo.deleteById(username);
		return passengerToDelete;
	}
	
	@Transactional
	// active passengers
	public List<Passenger> getActivePassengers() {
		List<Passenger> activePassengers = new ArrayList<>();
		passengerRepo.findByIsActive(true).forEach(activePassengers::add);
		return activePassengers;
	}
}
