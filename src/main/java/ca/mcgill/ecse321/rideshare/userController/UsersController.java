package ca.mcgill.ecse321.rideshare.userController;

//This controller class will fetch data from database

import java.util.List;

//import org.apache.derby.iapi.store.raw.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import ca.mcgill.ecse321.rideshare.model.User;
import ca.mcgill.ecse321.rideshare.repo.UserRepository;
import ca.mcgill.ecse321.rideshare.userController.UsersService;;



@RestController
public class UsersController {
	//this specifies your tool to retreive info from database.We'll use the repos we have created
	@Autowired
	public UserRepository userRepo;
	//private UsersService usersService;

	@GetMapping("/hello")
	public String sayHello() {
		return "This is Donat's REST API. Browse safe"; 
	}
	
	
	@GetMapping("/users")	
	public Page<User> getUsers(Pageable pageable) {
        return userRepo.findAll(pageable);
	}
	
	
	//create a user
	@PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepo.save(user);
    }
	
//	@RequestMapping("/users/?userName={username}")
//	public User getUser(@Pathvariable String username)
	
	
	/*
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public void addUser(@RequestBody User user) {
		usersService.addUser(user);
	}
	*/
}
