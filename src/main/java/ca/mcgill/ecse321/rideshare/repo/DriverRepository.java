package ca.mcgill.ecse321.rideshare.repo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.User;

public interface DriverRepository extends CrudRepository<Driver, String> {

	public List<Driver> findByIsActive(boolean status);
	public Driver findByUserName(String username);
	//void save(Driver driver);

	
	
	/*Car aCar = new Car();
	
	User user1 = new User("firstname", "lastname", 2, "donat@test.com", "01233445", "Alien", "Mars", "myUsername", true);
	User driver1 = new Driver("firstname", "lastname", 2, "donat@test.com", "01233445", "Alien", "Mars", "myUsername", true, 5555, aCar);
	User passenger1 = new Passenger("passenger", "lastname", 2, "donat@test.com", "01233445", "Alien", "Mars", "myUsername", true, "222222");*/
	
	
	
}
