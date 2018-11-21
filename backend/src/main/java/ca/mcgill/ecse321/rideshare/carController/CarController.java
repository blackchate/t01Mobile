package ca.mcgill.ecse321.rideshare.carController;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.mcgill.ecse321.rideshare.driverController.DriverService;
import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.model.Driver;

@CrossOrigin
@RestController
public class CarController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private DriverService driverService;
	
	//Get cars for a specific driver
	@RequestMapping("/drivers/{id}/cars")
	public List<Car> getAllCarsByDriver(@PathVariable String id) {
		return carService.getAllCarsForDriver(id);
	}
	
	@RequestMapping("/drivers/{driverId}/cars/{id}")
	public Optional<Car> getCar(@PathVariable int id) {
		return carService.getCar(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/drivers/{driverId}/cars")
	public void addCar(@RequestBody Car car, @PathVariable String driverId) {
		Driver driver = driverService.getDriver(driverId);
		int age = driver.getAge();
		int accountNumber = driver.getAccountNumber();
		int ranking = driver.getRanking();
		long tripCounter = driver.getTripCounter();
		//This doesn't overwrite the preexisting driver
		car.setDriver(new Driver("", "", age, "", "", "",
			"", driverId, true, accountNumber, ranking, tripCounter));
		carService.addCar(car);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/drivers/{driverId}/cars/{id}")
	public void updateCar(@RequestBody Car car, @PathVariable String driverId, @PathVariable int id) {
		carService.updateCar(id,  car);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/drivers/{driverId}/cars/{id}")
	public void deleteCar(@PathVariable int id) {
		carService.deleteCar(id);
	}

	
}
