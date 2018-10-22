package ca.mcgill.ecse321.rideshare.driverController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.User;
import ca.mcgill.ecse321.rideshare.repo.DriverRepository;

@Service
public class DriverService {
	
	@Autowired
	private DriverRepository driverRepo;
	
	Car car1 = new Car();
	
	public List<Driver> getAllDrivers() {
		List<Driver> drivers = new ArrayList<>();
		driverRepo.findAll().forEach(drivers::add);
		return drivers;
	}
	
	public Driver getDriver(String username) { 
		return driverRepo.findByUserName(username);
	}
	
	public void addDriver(Driver driver) {
		driverRepo.save(driver);
	}
	
	public void updateDriver(String username, Driver driver) {
		driverRepo.save(driver);
	}
	
	public Optional<Driver> deleteDriver(String username) { // delete driver with this username and return it as a response
		Optional<Driver> driverToDelete = driverRepo.findById(username);
		driverRepo.deleteById(username);
		return driverToDelete;
	}
	
	// active drivers
	public List<Driver> getActiveDrivers() {
		List<Driver> activeDrivers = new ArrayList<>();
		driverRepo.findByIsActive(true).forEach(activeDrivers::add);
		return activeDrivers;
	}
}
