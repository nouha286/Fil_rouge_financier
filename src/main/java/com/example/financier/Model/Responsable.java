package com.example.financier.Model;


import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Responsable extends User{

    private Etat etat;

}
