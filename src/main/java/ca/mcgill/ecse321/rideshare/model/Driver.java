package ca.mcgill.ecse321.rideshare.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import java.util.HashSet;

@Table(name = "driverInfo")
public class Driver extends User {
	
	@Id
	@GeneratedValue(generator = "driver_generator")
	@SequenceGenerator(
			name = "driver_generator",
			sequenceName = "driver_sequence",
			initialValue = 1000
			)
	private Long id;
	
	@Id
	private int accountNumber;
	@Column(columnDefinition = "trip")
	private Set<Trip> trip;
	@Column(columnDefinition = "car")
	private Car car;
	
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Constructor of driver should not have a car
	public Driver(String firstName, String lastName, int age, String email, String phoneNumber, String gender,
			String address, String userName, boolean isActive, int accountNumber, Car car) {
		super(firstName, lastName, age, email, phoneNumber, gender, address, userName, isActive);
		this.accountNumber = accountNumber;
		this.car = car;
		// TODO Auto-generated constructor stub
	}
	//constructor without car
	public Driver(String firstName, String lastName, int age, String email, String phoneNumber, String gender,
			String address, String userName, boolean isActive, int accountNumber) {
		super(firstName, lastName, age, email, phoneNumber, gender, address, userName, isActive);
		this.accountNumber = accountNumber;
		
	}


	public void setAccountNumber(int value) {
		this.accountNumber = value;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * <pre>
	 *           1..1     1..1
	 * Driver ------------------------- Car
	 *           driver        &lt;       car
	 * </pre>
	 */
	

	public void setCar(Car value) {
		this.car = value;
	}

	public Car getCar() {
		return this.car;
	}

	/**
	 * <pre>
	 *           1..1     0..*
	 * Driver ------------------------- Trip
	 *           driver        &lt;       trip
	 * </pre>
	 */
	

	public Set<Trip> getTrip() {
		if (this.trip == null) {
			this.trip = new HashSet<Trip>();
		}
		return this.trip;
	}

}
