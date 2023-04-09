package com.example.financier.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le nom ne peut pas être vide")
    private String nom;
    @NotBlank(message = "Le CNE ne peut pas être vide")
    @Column(unique = true)
    private String cne;
    @Email(message = "L'email doit être valide")
    @NotBlank(message = "L'email ne peut pas être vide")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "L'adresse ne peut pas être vide")
    private String adresse;
    @NotBlank(message = "Le métier ne peut pas être vide")
    private String metier;
    private Etat etat;
    @ManyToOne
    @NotNull

    private Agence agence;


    public Client(){};

}
