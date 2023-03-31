package com.example.financier.DTO;


import com.example.financier.Model.Client;
import lombok.Data;

@Data
public class CreditDTO {

    private Long clientId;
    private Double montantCredit;
    private String description;

}
