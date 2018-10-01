package ca.mcgill.ecse321.rideshare.userController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.rideshare.model.User;


@Service
public class UsersService {
	
	private List<User> users = new ArrayList<>(Arrays.asList(
			new User("Donat", "Kapesa", 2, "donat@test.com", "01233445", "Alien",
					"Mars", "myUsername"),
			new User("User2", "Lastname2", 55, "test@test.com", "555555", "Earthling",
					"Earth", "another username"),
			new User("earthling2", "lastname3", 901, "earth@test.com", "01233445", "Earthling",
					"Pacific Ocean", "username3")
			));
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public User getUser(String username) {
		return users.stream().filter(u -> u.getUserName().equals(username)).findFirst().get();
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void deleteUser(String username) {
		users.removeIf(u -> u.getUserName().equals(username));
	}
}
