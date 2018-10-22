// TODO: There has to be a way to put all this inside User class instead of having it inside Drivers, Passengers and System Admins right?

package ca.mcgill.ecse321.rideshare.driverController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.repo.DriverRepository;

@RestController
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	@RequestMapping("/drivers")
	public List<Driver> getAllDrivers(){
		return driverService.getAllDrivers();
	}
	
	@RequestMapping("/drivers/{username}")
	public Driver getDriver(@PathVariable String username) {
		return driverService.getDriver(username);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/drivers")
	public void addDriver(@RequestBody Driver driver) {
		driverService.addDriver(driver);
	}
		
	@RequestMapping(method=RequestMethod.PUT, value = "/drivers/{username}")
	public void updateDriver(@RequestBody Driver driver, @PathVariable String username) {
		driverService.updateDriver(username, driver);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="drivers/{username}")
	public void deleteDriver(@PathVariable String username) {
		driverService.deleteDriver(username);
	}
	
	/*
	}
	}
	public List<Driver> getAllDrivers() {
		return driverRepo.getAllDrivers(); // TODO: If null, show a message
	}
	
	@RequestMapping("/drivers/{username}")
	public Driver getDriver(@PathVariable String username) {
		return driverRepo.getDriver(username);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/drivers")
	public String addDriver(@RequestBody Driver driver) {
		driverRepo.addDriver(driver);
		return "YOU ADDED A DRIVER TO THE DATABASE";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/drivers/{username}")
	public Driver updateDriver(@RequestBody Driver driver, @PathVariable String username) {
		Driver oldDriver = driverRepo.getDriver(username); // null if no driver at that username yet
		driverRepo.updateDriver(username, driver);
		return driver;
	}
	// TODO: add ability to change username
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/drivers/{username}")
	public String deleteDriver(@PathVariable String username) { // TODO: if There's no driver to remove, return custom message
		Driver returnedValue = driverRepo.deleteDriver(username);
		if(returnedValue == null) {
			return "THERE IS NO DRIVER WITH THAT USERNAME TO DELETE";
		}
		return "YOU DELETED A DRIVER";
	}
	
	// active drivers
	// PROBABLY DID IT INSIDE SYSTEM ADMIN CLASS
//	@RequestMapping("/drivers/active") {
//		
//	}*/
}
