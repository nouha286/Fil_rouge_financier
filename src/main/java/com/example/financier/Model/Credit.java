package com.example.financier.Model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Etat etat;
    private LocalDate dateDemande;
    @ManyToOne
    private Client client;
    private Double montantCredit;
    private String description;




}
