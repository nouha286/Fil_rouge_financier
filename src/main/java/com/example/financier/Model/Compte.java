package com.example.financier.Model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String referenceCompte;
    @OneToOne
    private Client client;
    @NotNull
    private Double solde;
    private LocalDate dateCreation;
    private Etat etat;




}
