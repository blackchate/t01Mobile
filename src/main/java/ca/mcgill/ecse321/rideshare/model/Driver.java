package ca.mcgill.ecse321.rideshare.model;

import java.util.Set;

import javax.persistence.Entity;

import java.util.HashSet;

public class Driver extends User {
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver(String firstName, String lastName, int age, String email, String phoneNumber, String gender,
			String address, String userName, boolean isActive, int accountNumber, Car car) {
		super(firstName, lastName, age, email, phoneNumber, gender, address, userName, isActive);
		this.accountNumber = accountNumber;
		this.car = car;
		// TODO Auto-generated constructor stub
	}

	private int accountNumber;

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
	private Car car;

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
	private Set<Trip> trip;

	public Set<Trip> getTrip() {
		if (this.trip == null) {
			this.trip = new HashSet<Trip>();
		}
		return this.trip;
	}

}
