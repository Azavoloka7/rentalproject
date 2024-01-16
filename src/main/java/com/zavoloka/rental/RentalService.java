package com.zavoloka.rental;

import com.zavoloka.rental.model.Client;
import com.zavoloka.rental.model.Property;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    public void rentProperty(Client client, Property property) {
        // Check if the property is available for rent
        if (property.isAvailable()) {
            // Process the rental, update property status, client information, etc.
            property.setRented(true);
            property.setRentedBy(client);

            // Perform any other necessary actions related to the rental process

            System.out.println("Property rented successfully to " + client.getName());
        } else {
            System.out.println("Sorry, the property is not available for rent.");
        }
    }
}
