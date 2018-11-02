package ca.mcgill.cs.ecse321.rideshareapplication.ca.mcgill.cs.ecse321.redeshareapplication.responseclasses;

public class Car {
    private int registrationNumber;
    private Driver driver;
    private String make;
    private String colour;

    public Car(int registrationNumber, Driver driver, String make, String colour) {
        this.registrationNumber = registrationNumber;
        this.driver = driver;
        this.make = make;
        this.colour = colour;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getMake() {
        return make;
    }

    public String getColour() {
        return colour;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
