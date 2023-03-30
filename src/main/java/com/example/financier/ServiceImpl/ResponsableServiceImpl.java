package com.example.financier.ServiceImpl;

import com.example.financier.Model.Etat;
import com.example.financier.Model.Responsable;
import com.example.financier.Repository.ResponsableRepository;
import com.example.financier.Repository.RoleRepository;
import com.example.financier.Service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsableServiceImpl implements ResponsableService {
    @Autowired
    ResponsableRepository responsableRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Optional<Responsable> getResponsableById(Long responsableId) {
        return responsableRepository.findById(responsableId);
    }

    @Override
    public List<Responsable> getAllResponsables() {
        return responsableRepository.findAll();
    }

    @Override
    public Responsable createResponsable(Responsable responsable) {
        responsable.setEtat(Etat.Approuved);
        responsable.getRoles().add(roleRepository.findById(2L).get());
        return responsableRepository.save(responsable);
    }

    @Override
    public Boolean desapproveResponsableById(Long id) {
        Optional<Responsable> responsable=responsableRepository.findById(id);
        if (responsable.isPresent())
        {
            responsable.get().setEtat(Etat.refused);
            return true;
        }
        return false;
    }

    @Override
    public Boolean approveResponsableById(Long id) {
        Optional<Responsable> responsable=responsableRepository.findById(id);
        if (responsable.isPresent())
        {
            responsable.get().setEtat(Etat.Approuved);
            return true;
        }
        return false;
    }

    @Override
    public Responsable updateResponsable(Responsable responsable) {
        return null;
    }


}
