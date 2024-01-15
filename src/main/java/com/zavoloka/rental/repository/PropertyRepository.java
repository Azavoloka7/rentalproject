package com.zavoloka.rental.repository;

import com.zavoloka.rental.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    // ...
}