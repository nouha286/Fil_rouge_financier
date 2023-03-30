package com.example.financier.DTO;

import com.example.financier.Model.Responsable;
import lombok.Data;

import javax.persistence.OneToOne;
@Data
public class AgenceDTO {

    private Long id;
    private String adresse;
    private Long responsableId;
}
