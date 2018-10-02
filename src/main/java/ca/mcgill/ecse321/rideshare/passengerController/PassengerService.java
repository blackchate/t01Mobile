package ca.mcgill.ecse321.rideshare.passengerController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Passenger;

@Service
public class PassengerService {
	Car car1 = new Car();
	private List<Passenger> passengers = new ArrayList<>(Arrays.asList(
			new Passenger("Driver1", "ddsdsds", 2, "donat@test.com", "01233445", "Alien",
					"Mars", "myUsername", "55555555555"),
			new Passenger("Driver2", "Lassdfadtname2", 55, "test@test.com", "555555", "Earthling",
					"Earth", "another username", "7777777777777"),
			new Passenger("Driver3", "ssssssss", 901, "earth@test.com", "01233445", "Earthling",
					"Pacific Ocean", "sdfd", "8888888888888")
			));
	
	public List<Passenger> getAllPassengers() {
		return passengers;
	}
	
	public Passenger getPassenger(String username) { // 
		return passengers.stream().filter(u -> u.getUserName().equals(username)).findFirst().get();
	}
	
	public void addDriver(Passenger passenger) {
		passengers.add(passenger);
	}
	
	public void deletePassenger(String username) {
		passengers.removeIf(u -> u.getUserName().equals(username));
	}
}
