package com.example.financier.Controller;

import com.example.financier.Model.Client;
import com.example.financier.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {



    @Autowired
    private  ClientService clientService;

    @GetMapping("/")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long id) {
       Optional<Client>  client = clientService.getClientById(id);
       if (client.isPresent()) return new ResponseEntity<>(client.get(), HttpStatus.OK);
       return null;
    }

    @PostMapping("/")
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
        Client savedClient = clientService.createClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PutMapping("/updateClient")
    public ResponseEntity<Client> updateClient(@Valid @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(client);
        if (updatedClient==null) return new ResponseEntity<>(updatedClient, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable(value = "id") Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}