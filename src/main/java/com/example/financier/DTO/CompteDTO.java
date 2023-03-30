package com.example.financier.DTO;


import com.sun.istack.NotNull;
import lombok.Data;



@Data
public class CompteDTO {

    private Long id;
    @NotNull
    private Double solde;
    @NotNull
    private String nom;
    @NotNull
    private String cne;
    @NotNull
    private String email;
    @NotNull
    private String adresse;
    @NotNull
    private String metier;

}
