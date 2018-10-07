// TODO: There has to be a way to put all this inside User class instead of having it inside Drivers, Passengers and System Admins right?

package ca.mcgill.ecse321.rideshare.driverController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.User;
import ca.mcgill.ecse321.rideshare.repo.DriverRepository;

@RestController
public class DriverController {

	@Autowired
	private DriverRepository driverRepo;
	
	@GetMapping("/users/drivers")
	public Page<User> getAllDrivers(Pageable pageable) { 
		return driverRepo.findAll(pageable); // TODO: If null, show a message
	}
	
	@PostMapping("/users/drivers")
	public Driver createDriver(@Valid @RequestBody Driver driver) {
		return driverRepo.save(driver);
	}

}
