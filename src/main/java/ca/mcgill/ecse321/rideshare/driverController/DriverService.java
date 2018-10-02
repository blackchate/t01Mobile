package ca.mcgill.ecse321.rideshare.driverController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.User;

@Service
public class DriverService {
	Car car1 = new Car();
	private List<Driver> drivers = new ArrayList<>(Arrays.asList(
			new Driver("Driver1", "ddsdsds", 2, "donat@test.com", "01233445", "Alien",
					"Mars", "myUsername", 55, car1),
			new Driver("Driver2", "Lassdfadtname2", 55, "test@test.com", "555555", "Earthling",
					"Earth", "another username", 66, car1),
			new Driver("Driver3", "ssssssss", 901, "earth@test.com", "01233445", "Earthling",
					"Pacific Ocean", "sdfd", 77, car1)
			));
	
	public List<Driver> getAllDrivers() {
		return drivers;
	}
	
	public Driver getDriver(String username) {
		return drivers.stream().filter(u -> u.getUserName().equals(username)).findFirst().get();
	}
	
	public void addDriver(Driver driver) {
		drivers.add(driver);
	}
	
	public void deleteDriver(String username) {
		drivers.removeIf(u -> u.getUserName().equals(username));
	}
}
