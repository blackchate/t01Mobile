package ca.mcgill.ecse321.rideshare.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.rideshare.model.User;
import ca.mcgill.ecse321.rideshare.userController.UsersService;;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;

	@RequestMapping("/hello")
	public String sayHello() {
		return "This is Donat's REST API. Browse safe"; 
	}
	
//	@RequestMapping("/users")
//	public List<User> getAllUsers() {
//		return usersService.getAllUsers();
//	}
//
//	
//	@RequestMapping("/users/{username}")
//	public User getUser(@PathVariable String username){
//		return usersService.getUser(username);
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/users")
//	public void addUser(@RequestBody User user) {
//		usersService.addUser(user);
//	}
}
