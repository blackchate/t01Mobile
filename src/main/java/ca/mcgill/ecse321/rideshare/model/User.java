package ca.mcgill.ecse321.rideshare.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import java.util.HashSet;

@Entity
@Table(name = "userInfo")    //specify the table for this class
public class User extends AuditModel {
	
	@Id
    @GeneratedValue(generator = "user_generator")
	//this sequence generator will generate random primary key values for the table "userInfo" .
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence",                  
            initialValue = 1000
    )   
	private Long id;   //stores the above primary key
	
	
	@Column(columnDefinition = "is_active")
	private boolean isActice;
	@Column(columnDefinition = "first_name")
	private String firstName;
	@Column(columnDefinition = "last_name")
	private String lastName;
	@Column(columnDefinition = "age")
	private int age;
	@Column(columnDefinition = "email")
	private String email;
	@Column(columnDefinition = "phone_num")
	private String phoneNumber;
	@Column(columnDefinition = "gender")
	private String gender;
	@Column(columnDefinition = "address")
	private String address;
//	@Id
	private String userName;
	
	public User(String firstName, String lastName, int age, String email, String phoneNumber, String gender,
			String address, String userName, boolean isActive) {  //,Set<UserRole> userRole
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.address = address;
		this.userName = userName;
		this.isActice = isActive;
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


	public boolean isActice() {
		return isActice;
	}


	public void setActice(boolean isActice) {
		this.isActice = isActice;
	}

}
