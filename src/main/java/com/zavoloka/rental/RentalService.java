package com.zavoloka.rental;

import com.zavoloka.rental.model.Client;
import com.zavoloka.rental.model.Property;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    public void rentProperty(Client client, Property property) {
        // Check if the property is available for rent
        if (property.isAvailable()) {

            property.setRented(true);
            property.setRentedBy(client);



            System.out.println("Property rented successfully to " + client.getName());
        } else {
            System.out.println("Sorry, the property is not available for rent.");
        }
    }
}
