package ca.mcgill.ecse321.rideshare;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//more imports for Junit + Mockito
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//in conjunction with model (Car, Driver, Passenger, Trip, User)
//driver
import ca.mcgill.ecse321.rideshare.driverController.DriverController;
import ca.mcgill.ecse321.rideshare.driverController.DriverService;
//user
import ca.mcgill.ecse321.rideshare.userController.UsersController;
import ca.mcgill.ecse321.rideshare.userController.UsersService;
//admin
import ca.mcgill.ecse321.rideshare.adminOperationsController.AdminOperationsController;
import ca.mcgill.ecse321.rideshare.adminOperationsController.AdminOperationsService;
//passenger
import ca.mcgill.ecse321.rideshare.passengerController.PassengerController;
import ca.mcgill.ecse321.rideshare.passengerController.PassengerService;

//model (lines can be reduced later, for now just for readibility)
import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;
import ca.mcgill.ecse321.rideshare.model.Passenger;
import ca.mcgill.ecse321.rideshare.model.SpecificRating;
import ca.mcgill.ecse321.rideshare.model.Trip;
import ca.mcgill.ecse321.rideshare.model.User;

//repo
import ca.mcgill.ecse321.rideshare.repo.Repository; //Repository.java

//static imports for methods
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RideshareV1ApplicationTests {

	//@Before is used to execute set of preconditions before executing a test
	//@After methods are executed after the execution of every test
	//@BeforeClass before Test Case class (used if @test has lots of methods)
	//@AfterClass after ...

	//DAO: Data access objecy

	//create mocks for Car, Driver, Passenger, SpecificRating, Trip, User

	@Mock
	private Repository carDao, DriverDao, PassengerDao, SpecificRatingDao, TripDao, UserDao;


	@InjectMocks 
	private AdminOperationsController admincontrol;
	private AdminOperationsService adminservice;
	private DriverController drcontrol;
	private DriverService dservice;
	private PassengerController pcontrol;
	private PassengerService pservice;
	private UsersController ucontrol;
	private UsersService uservice;


	//ADMIN getAllTrips, getAllActiveUsers, getAllActiveTrips
	private static final String ADMIN_KEY = "TestAdmin";
	private static final String NONEXISTING_ADMINKEY = "NotAnAdmin";


	//DRIVER getAllDrivers, getDriver
	private static final String DRIVER_KEY = "TestDriver";
	private static final String NONEXISTING_DRIVERKEY = "NotADriver";

	//PASSENGER  getAllPassengers, getPassenger
	private static final String PASSENGER_KEY = "TestPassenger";
	private static final String NONEXISTING_PASSENGERKEY = "NotAPassenger";

	//USER getAllUsers, getUser

	private static final String USER_KEY = "TestUser";
	private static final String NONEXISTING_USERKEY = "NotAUser";

	@BeforeEach
	void setMockOutput() {
  		when(UserDao.getUser(anyString())).thenAnswer( (InvocationOnMock invocation) -> {
    		if(invocation.getArgument(0).equals(USER_KEY)) {
      			User user = new User();
      			user.setName(USER_KEY);
      			return user;
    			} 
    		else {
      			return null;
    			}
  			});
		}

	@Test
	public void testUserQueryFound() {
  		assertEquals(controller.queryParticipant(USER_KEY), USER_KEY);
	}

	@Test
	public void testUserQueryNotFound() {
  		assertEquals(controller.queryParticipant(NONEXISTING_USERKEY), EventRegistrationController.ERROR_NOT_FOUND_MESSAGE);
	}

}
