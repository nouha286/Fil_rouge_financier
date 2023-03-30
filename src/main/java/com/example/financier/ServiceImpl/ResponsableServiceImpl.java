package com.example.financier.ServiceImpl;

import com.example.financier.Model.Responsable;
import com.example.financier.Repository.ResponsableRepository;
import com.example.financier.Service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponsableServiceImpl implements ResponsableService {
    @Autowired
    ResponsableRepository responsableRepository;
    @Override
    public Optional<Responsable> getResponsableById(Long responsableId) {
        return responsableRepository.findById(responsableId);
    }


}
