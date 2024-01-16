package com.zavoloka.rental;

import com.zavoloka.rental.model.Client;
import com.zavoloka.rental.service.ClientService;
import com.zavoloka.rental.repository.ClientRepository;

import java.math.BigDecimal;
import java.util.List;


// Import other classes as needed

public class RentalOperations {

    private final ClientService clientService;

    // You can inject other services or repositories as needed

    public RentalOperations(ClientService clientService) {
        this.clientService = clientService;
    }

    // Add other methods for renting operations

    public void performRentingOperation(int clientIndex, int numberOfDays, BigDecimal dailyRate) {
        // Assuming you have a list of clients
        List<Client> clients = clientService.getAllClients();

        // Check if the clientIndex is within the valid range
        if (clientIndex >= 0 && clientIndex < clients.size()) {
            Client client = clients.get(clientIndex);

            // Calculate the rental cost
            BigDecimal rentalCost = client.calculateRentalCost(numberOfDays, dailyRate);

            // Rent the item using the calculated cost
            client.rentItem(rentalCost);
        } else {
            System.out.println("Invalid client index.");
        }
    }

    // Add other methods for returning items, checking balances, etc.

    // Example method to print all clients
    public void printAllClients() {
        List<Client> clients = clientService.getAllClients();
        for (Client client : clients) {
            System.out.println(client);
        }
    }
}
