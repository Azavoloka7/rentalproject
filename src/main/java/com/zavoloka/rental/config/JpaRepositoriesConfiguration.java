package com.zavoloka.rental.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.zavoloka.rental.repository")
public class JpaRepositoriesConfiguration {
    // ... your additional JPA configuration
}
