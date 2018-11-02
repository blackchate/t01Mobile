package ca.mcgill.ecse321.rideshare.model;

import java.util.Set;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;

@Entity
@Table(name = "driver")
public class Driver implements Serializable {
	
	@Id
	private String userName;
	
	@Column(name= "status")
	private boolean isActive;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "accountNumber")
	private int accountNumber;
	
	
	protected Driver () {
	}
	
	public Driver(String firstName, String lastName, int age, String email, String phoneNumber, String gender,
			String address, String userName, boolean isActive, int accountNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.address = address;
		this.userName = userName;
		this.isActive = isActive;
		this.accountNumber = accountNumber;
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


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setAccountNumber(int value) {
		this.accountNumber = value;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

}
