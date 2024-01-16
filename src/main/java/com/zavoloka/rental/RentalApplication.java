package com.zavoloka.rental;

import com.zavoloka.rental.model.Client;
import com.zavoloka.rental.model.Property;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
			Client client1 = new Client(1L, "John Doe", "john@example.com", "1234567890", 1000.0);
			Property property1 = new Property(1L, "Apartment A", "City Center", 2, true, 2000, 0.0);

			rentalService.rentProperty(client1, property1);

			System.out.println(client1);
			System.out.println(property1);
		};
	}
}
