package ca.mcgill.ecse321.rideshare.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.rideshare.model.Trip;

public interface TripRepository extends CrudRepository<Trip, String> {

	public Optional<Trip> findByIdentifier(Long identifier);
	public Optional<Trip> deleteByIdentifier(Long identifier);
	public List<Trip> findByPassengerUserName(String username);
	public List<Trip> findByDriverUserName(String username);
}
