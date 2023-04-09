package com.example.financier.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Agent extends User {
    private Etat etat;

    @ManyToOne
    private Agence agence;


}
