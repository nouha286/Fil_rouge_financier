package com.example.financier.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresse;
    @OneToOne
    private Responsable responsable;
    @OneToMany
    private List<Agent> agents;

}
