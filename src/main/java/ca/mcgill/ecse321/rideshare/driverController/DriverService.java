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
	private List<Driver> drivers = new ArrayList<>(Arrays.asList( // new ArrayList so that drivers list is mutable
			new Driver("Driver1", "ddsdsds", 2, "donat@test.com", "01233445", "Alien",
					"Mars", "myUsername", true, 55, car1),
			new Driver("Driver2", "Lassdfadtname2", 55, "test@test.com", "555555", "Earthling",
					"Earth", "another username", true, 66, car1),
			new Driver("Driver3", "ssssssss", 901, "earth@test.com", "01233445", "Earthling",
					"Pacific Ocean", "sdfd", false, 77, car1)
			));
	
	public List<Driver> getAllDrivers() {
		return drivers;
	}
	
	public Driver getDriver(String username) { // create a stream so that given the username that's passed i
		// for each driver I will check if driver.getUsername == username passed in. Then return the first match driver instance
		return drivers.stream().filter(d -> d.getUserName().equals(username)).findFirst().get();
	}
	
	public void addDriver(Driver driver) {
		drivers.add(driver);
	}
	
	public void updateDriver(String username, Driver driver) {
		for(int i = 0; i < drivers.size(); i++) {
			Driver d = drivers.get(i);
			if(d.getUserName().equals(username)) {
				drivers.set(i, driver);
				return;
			} // TODO: else create new user with that username 
		}
	}
	
	public Driver deleteDriver(String username) { // delete driver with this username and return it as a response
		Driver driverToDelete = null;
		for(int i = 0; i < drivers.size(); i++) {
			Driver d = drivers.get(i);
			if(d.getUserName().equals(username)) {
				driverToDelete = drivers.get(i);
				break;
			}
		}
		drivers.removeIf(u -> u.getUserName().equals(username));
		return driverToDelete;
	}
	
	// active drivers
	public List<Driver> getActiveDrivers() {
		List<Driver> activeDrivers = new ArrayList<>();
		for(int i = 0; i < drivers.size(); i++) {
			if(drivers.get(i).isActive()) {
				activeDrivers.add(drivers.get(i));
			}
		}
		return activeDrivers;
	}
}
