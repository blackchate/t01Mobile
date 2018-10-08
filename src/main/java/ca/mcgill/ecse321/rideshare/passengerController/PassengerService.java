package ca.mcgill.ecse321.rideshare.passengerController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.User;

@Service
public class PassengerService {
	Car car1 = new Car();
	private List<Passenger> passengers = new ArrayList<>(Arrays.asList(
			new Passenger("Passenger1", "ddsdsds", 2, "donat@test.com", "01233445", "Alien",
					"Mars", "myUsername", false, "55555555555"),
			new Passenger("Passenger2", "Lassdfadtname2", 55, "test@test.com", "555555", "Earthling",
					"Earth", "another username", false, "7777777777777"),
			new Passenger("Passenger3", "ssssssss", 901, "earth@test.com", "01233445", "Earthling",
					"Pacific Ocean", "sdfd", true, "8888888888888")
			));
	
	public List<Passenger> getAllPassengers() {
		return passengers;
	}
	
	public Passenger getPassenger(String username) { // 
		return passengers.stream().filter(u -> u.getUserName().equals(username)).findFirst().get();
	}
	
	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
	}
	
	public void updatePassenger(String username, Passenger passenger) {
		for(int i = 0; i < passengers.size(); i++) {
			Passenger p = passengers.get(i);
			if(p.getUserName().equals(username)) {
				passengers.set(i, passenger);
				return;
			} // TODO: else create new user with that username 
		}
	}
	
	public Passenger deletePassenger(String username) {
		Passenger passengerToRemove = null;
		for(int i = 0; i < passengers.size(); i++) {
			Passenger d = passengers.get(i);
			if(d.getUserName().equals(username)) {
				passengerToRemove = passengers.get(i);
				break;
			}
		}
		passengers.removeIf(u -> u.getUserName().equals(username));
		return passengerToRemove;
	}
	
	// active passengers
	public List<Passenger> getActivePassengers() {
		List<Passenger> activePassengers = new ArrayList<>();
		for(int i = 0; i < passengers.size(); i++) {
			if(passengers.get(i).isActive()) {
				activePassengers.add(passengers.get(i));
			}
		}
		return activePassengers;
	}
}
