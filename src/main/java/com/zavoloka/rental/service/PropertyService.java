package com.zavoloka.rental.service;



import com.zavoloka.rental.model.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyService {

    List<Property> getAllProperties();

    Optional<Property> getPropertyById(Long id);

    void saveProperty(Property property);

    void deleteProperty(Long id);
}
