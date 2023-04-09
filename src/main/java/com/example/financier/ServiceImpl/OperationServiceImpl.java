package com.example.financier.ServiceImpl;

import com.example.financier.DTO.CompteDTO;
import com.example.financier.DTO.OperationDto;
import com.example.financier.Model.Compte;
import com.example.financier.Model.Operation;
import com.example.financier.Model.Type;
import com.example.financier.Repository.OperationRepository;
import com.example.financier.Service.CompteService;
import com.example.financier.Service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationRepository operationRepository;
    @Autowired
    CompteService compteService;
    @Override
    public Operation deposer(OperationDto operationDto) {
        Optional<Compte> compte=compteService.getCompteById(operationDto.getCompte_id());
        if (compte.isPresent())
        {
            Operation operation=new Operation();
            operation.setDateOperation(LocalDate.now());
            operation.setCompte(compte.get());
            operation.setMontant(operationDto.getMontant());
            operation.setType(Type.Retrait);
            Operation operationSaved=operationRepository.save(operation);
            CompteDTO compteDTO=new CompteDTO();
            compteDTO.setId(operationDto.getCompte_id());
            compteDTO.setSolde(compte.get().getSolde()+operationDto.getMontant());
            compteService.updateCompte(compteDTO);
            return  operationSaved;
        }
        return null;
    }

    @Override
    public Operation retirer(OperationDto operationDto) {
        Optional<Compte> compte=compteService.getCompteById(operationDto.getCompte_id());
        if (compte.isPresent() && compte.get().getSolde()>=operationDto.getMontant())
        {
            Operation operation=new Operation();
            operation.setDateOperation(LocalDate.now());
            operation.setCompte(compte.get());
            operation.setMontant(operationDto.getMontant());
            operation.setType(Type.Retrait);
            Operation operationSaved=operationRepository.save(operation);
            CompteDTO compteDTO=new CompteDTO();
            compteDTO.setId(operationDto.getCompte_id());
            compteDTO.setSolde(compte.get().getSolde()-operationDto.getMontant());
            compteService.updateCompte(compteDTO);
            return  operationSaved;
        }
        return null;
    }

    @Override
    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    @Override
    public List<Operation> getOperationsByCompte(Long compteId) {
        Optional<Compte> compte=compteService.getCompteById(compteId);
        if (compte.isPresent())
        {
            return operationRepository.findOperationsByCompte(compte.get());
        }

        return null;
    }

    @Override
    public Operation transferer(OperationDto operationDto) {
        Optional<Compte> compteRecepteur=compteService.getCompteById(operationDto.getCompte_id_recepteur());
        Optional<Compte> compteEmetteur=compteService.getCompteById(operationDto.getCompte_id_emetteur());
        if (compteEmetteur.isPresent() && compteRecepteur.isPresent() && compteEmetteur.get().getSolde()>=operationDto.getMontant())
        {
            Operation operation=new Operation();
            operation.setDateOperation(LocalDate.now());
            operation.setCompte(compteEmetteur.get());
            operation.setCompte_recepteur(compteRecepteur.get());
            operation.setMontant(operationDto.getMontant());
            operation.setType(Type.Transfert);
            Operation operationSaved=operationRepository.save(operation);

            CompteDTO compteDTOemetteur=new CompteDTO();
            compteDTOemetteur.setId(operationDto.getCompte_id_emetteur());
            compteDTOemetteur.setSolde(compteEmetteur.get().getSolde()-operationDto.getMontant());
            compteService.updateCompte(compteDTOemetteur);

            CompteDTO compteDTOrecepteur=new CompteDTO();
            compteDTOemetteur.setId(operationDto.getCompte_id_recepteur());
            compteDTOemetteur.setSolde(compteRecepteur.get().getSolde()+operationDto.getMontant());
            compteService.updateCompte(compteDTOemetteur);
            return  operationSaved;

        }
        return null;
    }
}
