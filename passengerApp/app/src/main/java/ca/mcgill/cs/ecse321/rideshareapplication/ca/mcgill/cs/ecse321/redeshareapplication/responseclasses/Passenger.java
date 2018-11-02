package ca.mcgill.cs.ecse321.rideshareapplication.ca.mcgill.cs.ecse321.redeshareapplication.responseclasses;

import java.util.Set;

public class Passenger {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phoneNumber;
    private String gender;
    private String address;
    private String userName;
    private boolean isActive;
    private String creditCardNumber;
    private Set<Trip> trips;

    public Passenger(String firstName, String lastName, int age, String email, String phoneNumber, String gender, String address, String userName, boolean isActive, String creditCardNumber, Set<Trip> trips) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.userName = userName;
        this.isActive = isActive;
        this.creditCardNumber = creditCardNumber;
        this.trips = trips;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }
}
