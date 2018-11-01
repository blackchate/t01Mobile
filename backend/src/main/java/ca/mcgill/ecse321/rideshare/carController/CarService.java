package ca.mcgill.ecse321.rideshare.carController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.Car;
import ca.mcgill.ecse321.rideshare.repo.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepo;
	
	public List<Car> getAllCarsForDriver(String username){
		List<Car> cars = new ArrayList<>();
		carRepo.findByDriverUserName(username).forEach(cars::add);
		return cars;
	}
	
	public Optional<Car> getCar(int registrationNumber) {
		return carRepo.findByRegistrationNumber(registrationNumber);
	}
	
	public void addCar(Car car) {
		carRepo.save(car);
	}
	
	public void updateCar(int registrationNumber, Car car) {
		carRepo.save(car);
	}
	
	public Optional<Car> deleteCar(int registrationNumber) {
		Optional<Car> carToDelete = carRepo.findByRegistrationNumber(registrationNumber);
		carRepo.deleteByRegistrationNumber(registrationNumber);
		return carToDelete;
	}
}
