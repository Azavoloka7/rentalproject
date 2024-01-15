package com.zavoloka.rental.repository;

import com.zavoloka.rental.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByAvailableForRentTrue();

    List<Property> findByLocation(String location);
}
