package com.example.financier.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@RequiredArgsConstructor
public class Admin extends User{
}
