package com.example.financier.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Compte implements Serializable {
    public Compte()
    {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String referenceCompte;
    @NotBlank(message = "Le titulaire ne peut pas être vide")

    @OneToOne
    private Client client;

   @NotNull @NotEmpty(message = "Le solde de compte ne peut pas être vide")
   @DecimalMin(value = "0.0", message = "Le solde doit être positif ou nul")
   @Valid
    private Double solde;
    private LocalDate dateCreation;

    private Etat etat;




}
