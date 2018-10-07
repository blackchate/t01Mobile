package ca.mcgill.ecse321.rideshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing         //neccessary for persistence 
public class RideshareV1Application {

	public static void main(String[] args) {
		SpringApplication.run(RideshareV1Application.class, args);
	}
}
