package ca.mcgill.ecse321.rideshare.passengerController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.User;
import ca.mcgill.ecse321.rideshare.repo.PassengerRepository;

@Service
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepo;

	public List<Passenger> getAllPassengers() {
		List<Passenger> passengers = new ArrayList<>();
		passengerRepo.findAll().forEach(passengers::add);
		return passengers;
	}
	
	public Passenger getPassenger(String username) {
		return passengerRepo.findByUserName(username);
		}
	
	public void addPassenger(Passenger passenger) {
		passengerRepo.save(passenger);
	}
	
	public void updatePassenger(String username, Passenger passenger) {
		passengerRepo.save(passenger);
	}
	
	public Optional<Passenger> deletePassenger(String username) {
		Optional<Passenger> passengerToDelete = passengerRepo.findById(username);
		passengerRepo.deleteById(username);
		return passengerToDelete;
	}
	
	// active passengers
	public List<Passenger> getActivePassengers() {
		List<Passenger> activePassengers = new ArrayList<>();
		passengerRepo.findByIsActive(true).forEach(activePassengers::add);
		return activePassengers;
	}
}
