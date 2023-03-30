package com.example.financier.Controller;


import com.example.financier.DTO.AgenceDTO;
import com.example.financier.Model.Agence;
import com.example.financier.Repository.AgenceRepository;
import com.example.financier.Service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agences")
public class AgenceController {

    @Autowired
    AgenceService agenceService;
    @GetMapping
    public ResponseEntity<List<Agence>> getAllAgences() {
        List<Agence> agences = agenceService.getAllAgences();
        if (agences.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(agences);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Agence> getAgenceById(@PathVariable Long id) {
        Optional<Agence> agence = agenceService.getAgenceById(id);
        if (agence.isPresent()) {
            return ResponseEntity.ok(agence.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Agence> createAgence(@RequestBody @Valid AgenceDTO agence) {

        return ResponseEntity.status(HttpStatus.CREATED).body(agenceService.createAgence(agence));
    }

    @PutMapping("/Approve/{id}")

    public ResponseEntity<Void> approveAgenceById(@PathVariable Long id) {

        if (agenceService.approveAgenceById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/Desapprove/{id}")

    public ResponseEntity<Void> desapproveAgenceById(@PathVariable Long id) {

        if (agenceService.desapproveAgenceById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/update")
    public ResponseEntity<Agence> updateAgence(@RequestBody @Valid AgenceDTO agence) {
       Agence updatedAgence=agenceService.updateAgence(agence);
        if (updatedAgence!=null) {

            return ResponseEntity.ok(updatedAgence);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
