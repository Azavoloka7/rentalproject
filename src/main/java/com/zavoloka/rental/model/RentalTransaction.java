package com.zavoloka.rental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RentalTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime transactionTime;
    private Long clientId;
    private Long propertyId;
    private double amount;

    // Constructors, getters, setters, equals, hashCode, and toString methods...

    public RentalTransaction(String clientName, String rentalDuration, String rentalType, Property selectedProperty) {
        this.transactionTime = LocalDateTime.now();
        this.clientId = getClientIdFromName(clientName);
        this.propertyId = getPropertyIdFromType(rentalType);
        this.amount = calculateAmount(rentalDuration, selectedProperty);
    }

    // Placeholder methods, replace with actual logic in your application

    private Long getClientIdFromName(String clientName) {
        // Implement logic to retrieve the client ID based on the client name
        // For example, you might query a database to get the client ID.
        return 1L;  // Replace with the actual client ID or retrieval logic.
    }

    private Long getPropertyIdFromType(String rentalType) {
        // Implement logic to retrieve the property ID based on the rental type
        // For example, you might query a database to get the property ID.
        return 1L;  // Replace with the actual property ID or retrieval logic.
    }

    private double calculateAmount(String rentalDuration, Property selectedProperty) {
        // Implement logic to calculate the rental amount based on duration and property
        // For example, you might consider the property type and duration in your calculation.
        return 100.0;  // Replace with the actual amount calculation logic.
    }
}
