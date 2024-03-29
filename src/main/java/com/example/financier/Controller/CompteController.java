package com.example.financier.Controller;


import com.example.financier.DTO.CompteDTO;
import com.example.financier.Model.Compte;
import com.example.financier.ServiceImpl.CompteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comptes")
public class CompteController {


    @Autowired
    CompteServiceImpl compteService;
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<Compte>> getAllComptes() {
        List<Compte> comptes = compteService.getAllComptes();
        return new ResponseEntity<>(comptes, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Compte> getCompteById(@PathVariable("id") Long id) {
        Optional<Compte> compte = compteService.getCompteById(id);
        if (compte.isPresent()) {
            return new ResponseEntity<>(compte.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping("/")
    public ResponseEntity<Compte> createCompte(@Valid @RequestBody CompteDTO compte) {
        Compte savedCompte = compteService.createCompte(compte);

        return new ResponseEntity<>(savedCompte, HttpStatus.CREATED);
    }


    @PutMapping("/")
    public ResponseEntity<Compte> updateCompte( @Valid @RequestBody CompteDTO compte) {
        Optional<Compte> updatedCompte = compteService.getCompteById(compte.getId());
        if (updatedCompte.isPresent()) {
            return new ResponseEntity<>(updatedCompte.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCompte(@PathVariable("id") long id) {
        compteService.deleteCompte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<String> approveCompteById(@PathVariable Long id) {
        Boolean success = compteService.approveCompteById(id);
        if (success) {
            return ResponseEntity.ok("Compte approuvé avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Le compte n'existe pas");
        }
    }

    @PutMapping("/{id}/desapprove")
    public ResponseEntity<String> desapproveCompteById(@PathVariable Long id) {
        Boolean success = compteService.desapproveCompteById(id);
        if (success) {
            return ResponseEntity.ok("Compte désapprouvé avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Le compte n'existe pas");
        }
    }
}
