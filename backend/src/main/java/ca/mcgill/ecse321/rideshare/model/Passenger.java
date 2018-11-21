package ca.mcgill.ecse321.rideshare.model;

import java.util.Set;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;

@Entity
@Table(name = "passenger")
public class Passenger implements Serializable {
	
	@Id
	private String userName;
	
	@Column(name= "status")
	private Boolean isActive;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "creditCardNumber")
	private String creditCardNumber;
	
	@Column(name = "ranking")
	private Integer ranking;
	
	@Column(name = "tripCounter")
	private Long tripCounter;
	
	//SpecificRating specificRating;
	
	
	
	@ManyToMany(fetch = FetchType.EAGER,
			cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE
			})
	@JoinTable(name = "passenger_trip",
			joinColumns = { @JoinColumn(name = "passenger_id") },
			inverseJoinColumns = { @JoinColumn(name = "trip_id") 
			})
	private Set<Trip> trips;
	
	protected Passenger() {
		
	}

	public Passenger(String firstName, String lastName, Integer age, String email, String phoneNumber, 
			String gender,String address, String userName, Boolean isActive, String creditCardNumber, 
			Set<Trip> trips, Integer ranking, Long tripCounter) {
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
		this.ranking = ranking;
		this.tripCounter = tripCounter;
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

	

	public void setAge(Integer value) {
		this.age = value;
	}

	public Integer getAge() {
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


	public Boolean isActive() {
		return isActive;
	}


	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setCreditCardNumber(String value) {
		this.creditCardNumber = value;
	}

	public String getCreditCardNumber() {
		return this.creditCardNumber;
	}

/**
 * <pre>
 *           0..*     0..*
 * Passenger ------------------------- Trip
 *           passenger        &lt;       trip
 * </pre>
 */

	public void setTrip(Set<Trip> value) {
		this.trips = value;
	}
	
	public Set<Trip> getTrip() {
		if (this.trips == null) {
			this.trips = new HashSet<Trip>();
		}
    return this.trips;
	}
	
	public void setRanking(Integer rankingValue) {
		this.ranking = rankingValue;
	}
	
	public Integer getRanking() {
		return this.ranking;
	}
	
	public void setTripCounter(Long tripCounterValue) {
		this.tripCounter = tripCounterValue;
	}
	
	public Long getTripCounter() {
		return this.tripCounter;
	}

}
