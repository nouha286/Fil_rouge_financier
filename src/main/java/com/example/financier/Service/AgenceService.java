package com.example.financier.Service;

import com.example.financier.DTO.AgenceDTO;
import com.example.financier.Model.Agence;

import java.util.List;
import java.util.Optional;

public interface AgenceService {

    public List<Agence> getAllAgences();
    public Optional<Agence> getAgenceById(Long id);
    public Agence createOrUpdateAgence(AgenceDTO agence);
    public Boolean desapproveAgenceById(Long id);

    Boolean approveAgenceById(Long id);
    public Agence updateAgence(AgenceDTO agenceDTO);
}
