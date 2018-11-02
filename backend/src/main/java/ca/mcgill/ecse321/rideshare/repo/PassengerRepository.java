package ca.mcgill.ecse321.rideshare.repo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;

public interface PassengerRepository extends CrudRepository<Passenger, String> {

	public Passenger findByUserName(String username);
	public List<Passenger> findByIsActive(boolean status);


}