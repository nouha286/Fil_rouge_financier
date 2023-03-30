package com.example.financier.Service;

import com.example.financier.Model.Responsable;

import java.util.Optional;

public interface ResponsableService {
    Optional<Responsable> getResponsableById(Long responsableId);
}
