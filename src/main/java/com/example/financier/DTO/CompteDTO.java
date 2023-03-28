package com.example.financier.DTO;


import com.sun.istack.NotNull;
import lombok.Data;



@Data
public class CompteDTO {

    private Long id;
    @NotNull
    private Long clientId;
    @NotNull
    private Double solde;

}
