package ca.mcgill.ecse321.rideshare.userController;

import javax.persistence.EntityManager;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.rideshare.model.*;

@Repository
public class UserRepository {

	@Autowired
	EntityManager entityManager;
	
	@Transactional
	public User createUser(String firstName, String lastName,  int age, String email, String phoneNumber, String gender, String address, 
			String username, boolean isActive) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(username);
		user.setAge(age);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setGender(gender);
		user.setAddress(address);
		entityManager.persist(user);
		return user;
	}
	
	@Transactional
	public User getUser(String userName) {
		User user = entityManager.find(User.class, userName);
		return user;
	}
	
	@Transactional
	public Driver createDriver(Car car, int accountNumber) {
		Driver driver = new Driver();
		driver.setAccountNumber(accountNumber);
		driver.setCar(car);
		entityManager.persist(driver);
		return driver;
	}
	
	@Transactional
	public Driver getDriver(String userName) {
		Driver driver = entityManager.find(Driver.class, userName);
		return driver;
		
	}
	
	@Transactional
	public Passenger createPassenger(String creditCardNumber) {
		Passenger passenger = new Passenger();
		passenger.setCreditCardNumber(creditCardNumber);
		entityManager.persist(passenger);
		return passenger;	
	}
	
	@Transactional
	public Passenger getPassenger(String userName) {
		Passenger passenger = entityManager.find(Passenger.class, userName);
		return passenger;
	}

	
}

