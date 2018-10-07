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
import ca.mcgill.ecse321.rideshare.drivercontroller.DriverController;
import ca.mcgill.ecse321.rideshare.drivercontroller.DriverService;
//user
import ca.mcgill.ecse321.rideshare.usercontroller.UsersController;
import ca.mcgill.ecse321.rideshare.usercontroller.UsersService;
//admin
import ca.mcgill.ecse321.rideshare.adminoperationscontroller.AdminOperationsController;
import ca.mcgill.ecse321.rideshare.adminoperationscontroller.AdminOperationsService;
//passenger
import ca.mcgill.ecse321.rideshare.passengercontroller.PassengerController;
import ca.mcgill.ecse321.rideshare.passengercontroller.PassengerService;



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

	@Test
	public void contextLoads() throws Exception{

	}

}
