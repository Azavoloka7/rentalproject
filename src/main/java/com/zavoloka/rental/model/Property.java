package com.zavoloka.rental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private Integer bedrooms;
    private Boolean availableForRent;
    @Setter
    private Integer rentPrice;
    @Setter
    private Double rentAmount;
    private Client rentedBy;

    public Property(long id, String name, String location, int bedrooms, boolean availableForRent, int rentPrice, double rentAmount) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.bedrooms = bedrooms;
        this.availableForRent = availableForRent;
        this.rentPrice = rentPrice;
        this.rentAmount = rentAmount;
    }


    public boolean isAvailableForRent() {
        return availableForRent != null && availableForRent;
    }

    public void setAvailableForRent(boolean availableForRent) {
        this.availableForRent = availableForRent;
    }

    public Integer getRentPrice() {
        return rentPrice != null ? rentPrice : 0;
    }

    public String getPropertyName() {
        return name;
    }

    public boolean isRented() {
        return availableForRent != null && !availableForRent;
    }

    public void setRented(boolean rented) {
        this.availableForRent = !rented; // Invert the logic
    }

    public Double getRentAmount() {
        return rentAmount != null ? rentAmount : 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(id, property.id) &&
                Objects.equals(name, property.name) &&
                Objects.equals(location, property.location) &&
                Objects.equals(bedrooms, property.bedrooms) &&
                Objects.equals(availableForRent, property.availableForRent) &&
                Objects.equals(rentPrice, property.rentPrice) &&
                Objects.equals(rentAmount, property.rentAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, bedrooms, availableForRent, rentPrice, rentAmount);
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", bedrooms=" + bedrooms +
                ", availableForRent=" + availableForRent +
                ", rentPrice=" + rentPrice +
                ", rentAmount=" + rentAmount +
                '}';
    }

    public boolean isAvailable() {
        return !isRented(); // Property is available if it is not already rented
    }

    public void setRentedBy(Client client) {
        if (isAvailableForRent()) {
            this.availableForRent = false; // Property is being rented, so not available for rent
            this.rentedBy = client;
            System.out.println("Property rented by " + client.getName());
        } else {
            System.out.println("Property is already rented");
        }
    }
}
