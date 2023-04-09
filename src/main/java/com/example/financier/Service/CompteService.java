package com.example.financier.Service;

import com.example.financier.DTO.CompteDTO;
import com.example.financier.Model.Compte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CompteService {


    public List<Compte> getAllComptes();
    public Optional<Compte> getCompteById(Long id);
    public Compte createCompte( CompteDTO compte);
    public Compte updateCompte(CompteDTO compte);
    public void deleteCompte(Long id);

    Boolean desapproveCompteById(Long id);

    Boolean approveCompteById(Long id);
}
