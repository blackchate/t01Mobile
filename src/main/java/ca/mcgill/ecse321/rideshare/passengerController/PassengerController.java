package ca.mcgill.ecse321.rideshare.passengerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.User;
import ca.mcgill.ecse321.rideshare.repo.PassengerRepository;

@RestController
public class PassengerController {
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@RequestMapping("/users/passengers")
	public Page<User> getAllPassengers(Pageable pageable) {
		return passengerRepo.findAll(pageable);
	}
	
	@PostMapping("/users/passengers")
	public Driver createDriver(@Valid @RequestBody Driver driver) {
		return passengerRepo.save(driver);
	}
	
}