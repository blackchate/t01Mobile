package ca.mcgill.ecse321.rideshare.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.rideshare.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
