package com.zavoloka.rental.service;

import com.zavoloka.rental.model.Property;
import com.zavoloka.rental.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    @Override
    public void saveProperty(Property property) {
        propertyRepository.save(property);
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public List<Property> getAvailablePropertiesForRent() {
        return propertyRepository.findByAvailableForRentTrue();
    }

    @Override
    public List<Property> getPropertiesByLocation(String location) {
        return propertyRepository.findByLocation(location);
    }

    // Optional: Add equals, hashCode, and toString methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyServiceImpl that = (PropertyServiceImpl) o;
        return Objects.equals(propertyRepository, that.propertyRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyRepository);
    }

    @Override
    public String toString() {
        return "PropertyServiceImpl{" +
                "propertyRepository=" + propertyRepository +
                '}';
    }
}
