package ca.mcgill.ecse321.rideshare.driverController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.User;

@RestController
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	@RequestMapping("/drivers")
	public List<Driver> getAllUsers() {
		return driverService.getAllDrivers();
	}
	
}
