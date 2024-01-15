package com.zavoloka.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.boot.autoconfigure.ssl.SslAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.zavoloka.rental.model")
@EnableJpaRepositories(basePackages = "com.zavoloka.rental.repository")
@EnableAutoConfiguration(exclude = {
		ConfigurationPropertiesAutoConfiguration.class,
		SslAutoConfiguration.class,
		LifecycleAutoConfiguration.class,
		PropertyPlaceholderAutoConfiguration.class,
		ApplicationAvailabilityAutoConfiguration.class,
		ProjectInfoAutoConfiguration.class
})
public class RentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalApplication.class, args);
	}
}
