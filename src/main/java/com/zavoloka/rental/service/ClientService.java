package com.zavoloka.rental.service;

import com.zavoloka.rental.model.Client;
import com.zavoloka.rental.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(int clientId) {
        Optional<Client> optionalClient = clientRepository.findById((long) clientId);
        return optionalClient.orElse(null);
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public boolean updateClient(int clientId, Client updatedClient) {
        Optional<Client> optionalExistingClient = clientRepository.findById((long) clientId);
        optionalExistingClient.ifPresent(existingClient -> {
            // Update client properties
            existingClient.setName(updatedClient.getName());
            existingClient.setEmail(updatedClient.getEmail());
            existingClient.setPhoneNumber(updatedClient.getPhoneNumber());
            existingClient.setBalance(updatedClient.getBalance());
            // Save the updated client
            clientRepository.save(existingClient);
        });
        return false;
    }

    public boolean deleteClient(int clientId) {
        clientRepository.deleteById((long) clientId);
        return false;
    }
}
