package ca.mcgill.ecse321.rideshare.driverController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.repo.DriverRepository;

@CrossOrigin
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
	
	
}
