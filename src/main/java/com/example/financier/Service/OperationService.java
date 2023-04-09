package com.example.financier.Service;

import com.example.financier.DTO.OperationDto;
import com.example.financier.Model.Compte;
import com.example.financier.Model.Operation;

import java.util.List;

public interface OperationService {

    public Operation deposer(OperationDto operationDto);
    public Operation retirer(OperationDto operationDto);
    public List<Operation> getAllOperations();

    public List<Operation> getOperationsByCompte(Long compteId);
    public Operation transferer(OperationDto operationDto);


}
