package com.zavoloka.rental;

import com.zavoloka.rental.model.Client;
import com.zavoloka.rental.model.Property;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

@SpringBootApplication
@EntityScan(basePackages = "com.zavoloka.rental.model")
@EnableJpaRepositories(basePackages = "com.zavoloka.rental.repository")
public class RentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(RentalService rentalService) {
		return args -> {
			// Creating a Client instance
			Client client1 = new Client(1L, "John Doe", "john@example.com", "1234567890", new BigDecimal("1000.00"));

			// Creating a Property instance with the propertyId parameter
			Property property1 = new Property(1L, "Apartment A", "City Center", 3, true, 3, new BigDecimal("10000.00"), new BigDecimal("10000.00"));

			// Renting the property to the client
			rentalService.rentProperty(client1, property1);

			// Displaying client and property details
			System.out.println(client1);
			System.out.println(property1);
		};
	}
}
