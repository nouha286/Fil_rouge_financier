package com.example.financier.Repository;

import com.example.financier.Model.Compte;
import com.example.financier.Model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {


    List<Operation> findOperationsByCompte(Compte compte);
}
