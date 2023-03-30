package com.example.financier.Service;


import com.example.financier.Model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    public List<Client> getAllClients();
    public Optional<Client> getClientById(Long id);
    public Client createClient(Client client);
    public Client updateClient(Client client);
    public void deleteClient(Long id);
}
