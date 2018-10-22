package ca.mcgill.ecse321.rideshare.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car implements Serializable{

@Id
@GeneratedValue
private int registrationNumber;

public void setRegistrationNumber(int value) {
   this.registrationNumber = value;
}

public int getRegistrationNumber() {
   return this.registrationNumber;
}

/**
 * <pre>
 *           1..1     1..1
 * Car ------------------------- Driver
 *           car        &gt;       driver
 * </pre>
 */
@OneToOne(mappedBy = "car")
private Driver driver;

public void setDriver(Driver value) {
   this.driver = value;
}

public Driver getDriver() {
   return this.driver;
}

}
