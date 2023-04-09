package com.example.financier.DTO;


import com.example.financier.Model.Compte;
import com.example.financier.Model.Type;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import java.time.LocalDate;

@Data
public class OperationDto {
    private Long id;

    private Double montant;
    private Long compte_id_emetteur;
    private Long compte_id_recepteur;
    private Long compte_id;
}
