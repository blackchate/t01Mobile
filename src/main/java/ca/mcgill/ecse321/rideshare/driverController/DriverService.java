/*package ca.mcgill.ecse321.rideshare.driverController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.User;

@Service
public class DriverService {
	
	@Autowired
	private DriverRepository driverRepository;
	
	Car car1 = new Car();
	
	public List<Driver> getAllDrivers() {
		// iterate through items of db and add each to list drivers
		List<Driver> drivers = new ArrayList<>();
		driverRepository.findAll().forEach(drivers::add);
		return drivers;
	}
	
	public Optional<Driver> getDriver(String username) { // create a stream so that given the username that's passed i
		// for each driver I will check if driver.getUsername == username passed in. Then return the first match driver instance
		return driverRepository.findById(username);
	}
	
	public void addDriver(Driver driver) {
		
		driverRepository.save(driver);
	}
	
	public void updateDriver(String username, Driver driver) {
		driverRepository.save(driver);
		// TODO: else create new user with that username
	}
	
	public String deleteDriver(String username) { // delete driver with this username and return it as a response
		String driverToDelete = driverRepository.findById(username).toString();
		driverRepository.deleteById(username);;
		return driverToDelete;
	}
}*/
