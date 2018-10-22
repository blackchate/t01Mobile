package ca.mcgill.ecse321.rideshare.repo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;

public interface DriverRepository extends CrudRepository<Driver, String> {

	public List<Driver> findByIsActive(boolean status);
	public Driver findByUserName(String username);
}
