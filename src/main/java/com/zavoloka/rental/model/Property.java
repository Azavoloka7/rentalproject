package com.zavoloka.rental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Setter
@Getter
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;
    private String name;
    private String location;
    private int bedrooms;
    private boolean isAvailable;
    private int someParameter;
    private BigDecimal dailyRate;
    private BigDecimal someOtherParameter;

    @ManyToOne
    private Client rentedBy;

    // Constructors

    protected Property() {
        // Default constructor for JPA
    }

    public Property(String name, String location, int bedrooms, boolean isAvailable, int someParameter, BigDecimal dailyRate, BigDecimal someOtherParameter) {
        this.name = name;
        this.location = location;
        this.bedrooms = bedrooms;
        this.isAvailable = isAvailable;
        this.someParameter = someParameter;
        this.dailyRate = dailyRate;
        this.someOtherParameter = someOtherParameter;
    }

    public Property(Long propertyId, String name, String location, int bedrooms, boolean isAvailable, int someParameter, BigDecimal dailyRate, BigDecimal someOtherParameter) {
        this.propertyId = propertyId;
        this.name = name;
        this.location = location;
        this.bedrooms = bedrooms;
        this.isAvailable = isAvailable;
        this.someParameter = someParameter;
        this.dailyRate = dailyRate;
        this.someOtherParameter = someOtherParameter;
    }

    // Additional methods

    public boolean isAvailableForRent() {
        return isAvailable;
    }

    public BigDecimal getRentPrice() {
        return dailyRate != null ? dailyRate : BigDecimal.ZERO;
    }

    public boolean isRented() {
        return rentedBy != null;
    }

    public BigDecimal getRentAmount() {
        return isRented() ? BigDecimal.ZERO : getRentPrice();
    }

    // Equals, hashCode, and toString methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(propertyId, property.propertyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId);
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", bedrooms=" + bedrooms +
                ", isAvailable=" + isAvailable +
                ", someParameter=" + someParameter +
                ", dailyRate=" + dailyRate +
                ", someOtherParameter=" + someOtherParameter +
                ", rentedBy=" + (rentedBy != null ? rentedBy.getName() : "None") +
                '}';
    }

    // Methods for Renting and Returning

    public boolean isAvailable() {
        return !isRented();
    }

    public void setRentedBy(Client client) {
        if (isAvailableForRent()) {
            this.isAvailable = false;
            this.rentedBy = client;
            System.out.println("Property rented by " + client.getName());
        } else {
            System.out.println("Property is already rented");
        }
    }

    public void setAvailableForRent(boolean availableForRent) {
        isAvailable = availableForRent;
    }

    public void returnProperty() {
        if (isRented()) {
            this.isAvailable = true;
            this.rentedBy = null;
            System.out.println("Property returned and is now available for rent.");
        } else {
            System.out.println("Property is not currently rented.");
        }
    }

    public void setRented(boolean rented) {
        if (rented) {
            // If true, the property is rented
            if (!isAvailableForRent()) {
                System.out.println("Property is already rented.");
            } else {
                this.isAvailable = false;
                System.out.println("Property is now rented.");
            }
        } else {
            // If false, the property is not rented
            this.isAvailable = true;
            this.rentedBy = null;
            System.out.println("Property is now available for rent.");
        }
    }

}
