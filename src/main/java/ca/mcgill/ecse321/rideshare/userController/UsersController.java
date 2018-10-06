package ca.mcgill.ecse321.rideshare.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.User;
import ca.mcgill.ecse321.rideshare.userController.UserRepository;;

@RestController
public class UsersController {
	
	@Autowired
	private UserRepository repository;

	@RequestMapping("/")
	public String sayHello() {
		return "This is Donat's REST API. Browse safe"; 
	}
	
	/*@RequestMapping("/users")
	public List<User> getAllUsers() {
		return usersService.getAllUsers();
	}
	
//	@RequestMapping("/users/?userName={username}")
//	public User getUser(@Pathvariable String username)
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public void addUser(@RequestBody User user) {
		usersService.addUser(user);
	}*/
	
	@PostMapping("/users/{username}")
	public String createUser(@PathVariable("username") String username, String firstName, String lastName, int age, String email, String phoneNumber,
			String gender, String address, boolean isActive) {
		User user = repository.createUser(firstName, lastName, age, email, phoneNumber, gender, address, username, isActive);
		return user.getUserName();
	}
	
	@PostMapping("/users/drivers/{username}")
	public String createDriver(int accountNumber, Car car) {
		Driver driver = repository.createDriver(car, accountNumber);
		return driver.getUserName();
	}
	
	@PostMapping("/users/passengers/{username}")
	public String createPassenger(String creditCardNumber) {
		Passenger passenger = repository.createPassenger(creditCardNumber);
		return passenger.getUserName();
	}
	
	@GetMapping("/users/{userName}")
	public String queryUser(@PathVariable("userName") String userName) {
		User user = repository.getUser(userName);
		if(user == null) {
			return  "NOT FOUND";
		}
		return user.getUserName();
	}
	
	@GetMapping("/users/drivers/{username}")
	public String queryDriver(@PathVariable("userName") String userName) {
		Driver driver = repository.getDriver(userName);
		if(driver == null) {
			return  "NOT FOUND";
		}
		return driver.getUserName();
	}
	
	@GetMapping("/users/passengers/{username}")
	public String queryPassenger(@PathVariable("userName") String userName) {
		Passenger passenger = repository.getPassenger(userName);
		if(passenger == null) {
			return  "NOT FOUND";
		}
		return passenger.getUserName();
	}

}
	

