package com.zavoloka.rental.controller;

import com.zavoloka.rental.model.Client;
import com.zavoloka.rental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public Client getClientById(@PathVariable Long clientId) {
        return clientService.getClientById(Math.toIntExact(clientId));
    }

    @PostMapping
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @PutMapping("/{clientId}")
    public void updateClient(@PathVariable Long clientId, @RequestBody Client updatedClient) {
        clientService.updateClient(Math.toIntExact(clientId), updatedClient);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable Long clientId) {
        clientService.deleteClient(Math.toIntExact(clientId));
    }
}
