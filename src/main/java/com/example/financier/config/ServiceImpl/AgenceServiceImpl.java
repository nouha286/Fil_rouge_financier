package com.example.financier.config.ServiceImpl;

import com.example.financier.DTO.AgenceDTO;
import com.example.financier.Model.Agence;
import com.example.financier.Model.Etat;
import com.example.financier.Model.Responsable;
import com.example.financier.Repository.AgenceRepository;
import com.example.financier.Service.AgenceService;
import com.example.financier.Service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AgenceServiceImpl implements AgenceService {

    @Autowired
    AgenceRepository agenceRepository;
    @Autowired
    ResponsableService responsableService;
    @Override
    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Optional<Agence>  getAgenceById(Long id) {
        return agenceRepository.findById(id);
    }

    @Override
    public Agence createOrUpdateAgence(AgenceDTO agence) {

        Optional<Responsable> responsable=responsableService.getResponsableById(agence.getResponsableId());
        if(responsable.isPresent())
        {
            Agence agenceSaved=new Agence();
            agenceSaved.setAdresse(agence.getAdresse());
            agenceSaved.setResponsable(responsable.get());
            return agenceRepository.save(agenceSaved);
        }
        return null;
    }

    @Override
    public Boolean desapproveAgenceById(Long id) {

        Optional<Agence> agence=agenceRepository.findById(id);
        if (agence.isPresent())
        {
            agence.get().setEtat(Etat.refused);
            agenceRepository.save(agence.get());
            return true;
        }
      return false;
    }

    @Override
    public Boolean approveAgenceById(Long id) {

        Optional<Agence> agence=agenceRepository.findById(id);
        if (agence.isPresent())
        {
            agence.get().setEtat(Etat.Approuved);
            agenceRepository.save(agence.get());
            return true;
        }
      return false;
    }

    @Override
    public Agence updateAgence(AgenceDTO agenceDTO) {
        Optional<Agence> agenceUpdated=agenceRepository.findById(agenceDTO.getId());
        if (agenceUpdated.isPresent())
        {
            if (agenceDTO.getAdresse()!=null && !agenceUpdated.get().getAdresse().equals(agenceDTO.getAdresse()))  agenceUpdated.get().setAdresse(agenceDTO.getAdresse());

            if (agenceDTO.getResponsableId()!=null)
            {
               Optional<Responsable>  responsable=responsableService.getResponsableById(agenceDTO.getResponsableId());
               if (responsable.isPresent() && !agenceUpdated.get().getResponsable().equals(responsable))
               {
                   agenceUpdated.get().setResponsable(responsable.get());
               }
            }
         return agenceRepository.save(agenceUpdated.get());
        }

        return null;
    }
}
