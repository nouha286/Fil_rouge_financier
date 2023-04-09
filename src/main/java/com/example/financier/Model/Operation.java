package com.example.financier.Model;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
public class Operation {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOperation;
    @NotNull
    @DecimalMin(value = "0.0", message = "Le solde doit être positif ou nul")
    private Double montant;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;
    @ManyToOne
    Compte compte;
}
