package ca.mcgill.ecse321.rideshare.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.rideshare.model.Car;

public interface CarRepository extends CrudRepository<Car, String> {
	public List<Car> findByDriverUserName(String username);
	public Optional<Car> findByRegistrationNumber(int registrationNumber);
	public Optional<Car> deleteByRegistrationNumber(int registrationNumber);
}
