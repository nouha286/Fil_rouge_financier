package com.example.financier.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@Entity
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "L'adresse ne doit pas être vide")
    private String adresse;
    @OneToOne
    @NotBlank(message = "Le responsable ne doit pas être vide")
    private Responsable responsable;

    private Etat etat;


}
