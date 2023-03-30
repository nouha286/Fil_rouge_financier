package com.example.financier.ServiceImpl;


import com.example.financier.Model.Client;
import com.example.financier.Repository.ClientRepository;
import com.example.financier.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        Optional<Client> existingClient = clientRepository.findById(client.getId());
               if(existingClient.isPresent())
               {
                   if (client.getAdresse()!=null && !client.getAdresse().equals(existingClient.get().getAdresse())) existingClient.get().setAdresse(client.getAdresse());

                   if (client.getCne()!=null && !client.getCne().equals(existingClient.get().getCne())) existingClient.get().setCne(client.getCne());

                   if (client.getEmail()!=null && !client.getEmail().equals(existingClient.get().getEmail())) existingClient.get().setEmail(client.getEmail());

                   if (client.getMetier()!=null && !client.getMetier().equals(existingClient.get().getMetier())) existingClient.get().setMetier(client.getMetier());

                   if (client.getNom()!=null && !client.getNom().equals(existingClient.get().getNom()))  existingClient.get().setNom(client.getNom());


                   return clientRepository.save(existingClient.get());
               }
               return null;

    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
