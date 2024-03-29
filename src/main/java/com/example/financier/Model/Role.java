package com.example.financier.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameRole;

    public Role() {

    }




    public Role(Long id, String nameRole) {
        this.id = id;
        this.nameRole = nameRole;
    }

    public Role(String nameRole) {
        this.nameRole = nameRole;
    }


}
