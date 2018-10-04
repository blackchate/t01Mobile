package ca.mcgill.ecse321.rideshare.adminOperationsController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.User;

@Service
public class AdminOperationsService {
	Car car1 = new Car();
	private List<User> allUsers = new ArrayList<>(Arrays.asList( // new ArrayList so that drivers list is mutable
			new User("Driver1", "ddsdsds", 2, "donat@test.com", "01233445", "Alien",
					"Mars", "myUsername"),
			new Driver("Driver1", "Lassdfadtname2", 55, "test@test.com", "555555", "Earthling",
					"Earth", "another username", 66, car1),
			new Passenger("Driver3", "ssssssss", 901, "earth@test.com", "01233445", "Earthling",
					"Pacific Ocean", "sdfd", "creditCardInfo")
			));
	
}
