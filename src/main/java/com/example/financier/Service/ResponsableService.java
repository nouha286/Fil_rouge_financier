package com.example.financier.Service;


import com.example.financier.Model.Responsable;

import java.util.List;
import java.util.Optional;

public interface ResponsableService {
    Optional<Responsable> getResponsableById(Long responsableId);

    public List<Responsable> getAllResponsables();

    public Responsable createResponsable(Responsable responsable);
    public Boolean desapproveResponsableById(Long id);

    Boolean approveResponsableById(Long id);
    public Responsable updateResponsable(Responsable responsable);
}
