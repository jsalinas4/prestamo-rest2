package com.TechConnecGrupo3.TechConnecapi.api;

import com.TechConnecGrupo3.TechConnecapi.model.entity.Client;
import com.TechConnecGrupo3.TechConnecapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    // Create a new client
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client newClient = clientRepository.save(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    // Get all clients
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    // Get a client by ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> clientOpt = clientRepository.findById(id);
        return clientOpt.map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a client
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        Optional<Client> clientOpt = clientRepository.findById(id);
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            client.setFirstName(clientDetails.getFirstName());
            client.setLastName(clientDetails.getLastName());
            client.setClientType(clientDetails.getClientType());
            client.setDniRuc(clientDetails.getDniRuc());
            client.setAddress(clientDetails.getAddress());
            client.setPhone(clientDetails.getPhone());
            client.setEmail(clientDetails.getEmail());

            Client updatedClient = clientRepository.save(client);
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a client
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
