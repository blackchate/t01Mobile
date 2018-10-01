package ca.mcgill.ecse321.rideshare.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.HashSet;

@Entity
public class User {
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String phoneNumber;
	private String gender;
	private String address;
	@Id
	private String userName;
	
	public User(String firstName, String lastName, int age, String email, String phoneNumber, String gender,
			String address, String userName) {  //,Set<UserRole> userRole
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.address = address;
		this.userName = userName;
//		this.userRole = userRole;
	}


	public User() {
		
	}
	

	public void setFirstName(String value) {
		this.firstName = value;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String value) {
		this.lastName = value;
	}

	public String getLastName() {
		return this.lastName;
	}

	

	public void setAge(int value) {
		this.age = value;
	}

	public int getAge() {
		return this.age;
	}

	

	public void setEmail(String value) {
		this.email = value;
	}

	public String getEmail() {
		return this.email;
	}

	

	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	

	public void setGender(String value) {
		this.gender = value;
	}

	public String getGender() {
		return this.gender;
	}

	

	public void setAddress(String value) {
		this.address = value;
	}

	public String getAddress() {
		return this.address;
	}

	

	public void setUserName(String value) {
		this.userName = value;
	}

	public String getUserName() {
		return this.userName;
	}

}
