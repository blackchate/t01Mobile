package ca.mcgill.ecse321.rideshare.model;


public class Car {
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
private Driver driver;

public void setDriver(Driver value) {
   this.driver = value;
}

public Driver getDriver() {
   return this.driver;
}

}
