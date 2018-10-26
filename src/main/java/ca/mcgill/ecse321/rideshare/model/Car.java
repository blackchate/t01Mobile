package ca.mcgill.ecse321.rideshare.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car implements Serializable{

@Id
private int registrationNumber;

 @Column(name = "make")
 private String make;
 
 @Column(name = "colour")
 private String colour;

public Car(int registrationNumber, Driver driver, String make, String colour) {
	this.registrationNumber = registrationNumber;
	this.driver = driver;
}

protected Car() {
	
}

public void setRegistrationNumber(int value) {
   this.registrationNumber = value;
}

public int getRegistrationNumber() {
   return this.registrationNumber;
}

public void setMake(String make) {
	this.make = make;
}

public String getMake() {
	return this.make;
}

public void setColour(String colour) {
	this.colour = colour;
}

public String getColour() {
	return this.colour;
}

/**
 * <pre>
 *           1..1     1..1
 * Car ------------------------- Driver
 *           car        &gt;       driver
 * </pre>
 */

//Establishing relationship between a driver and the many cars they can have.
@ManyToOne
private Driver driver;

public void setDriver(Driver value) {
   this.driver = value;
}

public Driver getDriver() {
   return this.driver;
}

}
