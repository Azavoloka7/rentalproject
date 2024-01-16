package com.zavoloka.rental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String name;
    private String email;
    private String phoneNumber;
    private BigDecimal balance;

    @OneToMany(mappedBy = "", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Property> rentedProperties = new HashSet<>();

    // Constructors

    protected Client() {
        // Default constructor for JPA
    }

    public Client(String name, String email, String phoneNumber, BigDecimal balance) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public Client(Long clientId, String name, String email, String phoneNumber, BigDecimal balance) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    // Equals, hashCode, and toString methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientId, client.clientId) &&
                Objects.equals(name, client.name) &&
                Objects.equals(email, client.email) &&
                Objects.equals(phoneNumber, client.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, name, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    // Additional Methods

    public BigDecimal calculateRentalCost(int numberOfDays, BigDecimal dailyRate) {
        if (numberOfDays <= 0 || dailyRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid numberOfDays or dailyRate");
        }

        return dailyRate.multiply(BigDecimal.valueOf(numberOfDays));
    }

    public void rentItem(BigDecimal rentalCost) {
        if (rentalCost.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid rentalCost");
        }

        if (getBalance().compareTo(rentalCost) >= 0) {
            // Sufficient balance, proceed with the rental
            setBalance(getBalance().subtract(rentalCost));
            System.out.println("Item rented successfully. Remaining balance: " + getBalance());
        } else {
            System.out.println("Insufficient balance to rent the item.");
        }
    }

    // Methods for Renting and Returning Properties

    public void rentProperty(Property property) {
        property.setRentedBy(this);
        rentedProperties.add(property);
    }

    public void returnProperty(Property property) {
        property.setRentedBy(null);
        rentedProperties.remove(property);
    }
}
