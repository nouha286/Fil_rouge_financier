package com.example.financier.DTO;


import lombok.Data;

@Data
public class AgentDTO {
    private Long id;
    private Long agenceId;
    private String name;
    private String email;
    private String password;

}
