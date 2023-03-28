package com.example.financier.ServiceImpl;

import com.example.financier.DTO.CompteDTO;
import com.example.financier.Model.Client;
import com.example.financier.Model.Compte;
import com.example.financier.Model.Etat;
import com.example.financier.Repository.ClientRepository;
import com.example.financier.Repository.CompteRepository;
import com.example.financier.Service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    CompteRepository compteRepository;

    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }



    @Override
    public Optional<Compte> getCompteById(Long id) {
        return compteRepository.findById(id);
    }

    @Override
    public Compte createCompte(CompteDTO compte) {

        Compte compteSaved=new Compte();
        compteSaved.setReferenceCompte(UUID.randomUUID().toString());
        compteSaved.setEtat(Etat.refused);
        compteSaved.setSolde(compte.getSolde());
        compteSaved.setDateCreation(LocalDate.now());
        Optional<Client> client=clientRepository.findById(compte.getId());
        if(client.isPresent())
        {
            return compteRepository.save(compteSaved);
        }
        return null;
    }

    @Override
    public Compte updateCompte(CompteDTO compte) {
        Optional<Compte> compteUpdated=compteRepository.findById(compte.getId());
        if (compteUpdated.isPresent())
        {
            compteUpdated.get().setSolde(compte.getSolde());
            Optional<Client> client=clientRepository.findById(compte.getId());
            if(client.isPresent()) {

                compteUpdated.get().setClient(client.get());
            }
            return compteRepository.save(compteUpdated.get());
        }
        return null;
    }



    @Override
    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }
}
