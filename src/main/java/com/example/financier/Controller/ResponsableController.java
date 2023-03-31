package com.example.financier.Controller;

import com.example.financier.DTO.ResponsableDto;
import com.example.financier.Model.Responsable;
import com.example.financier.Service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responsables")
public class ResponsableController {

        @Autowired
        ResponsableService responsableService;


        @GetMapping
        public ResponseEntity<List<Responsable>> getAllResponsables() {
            List<Responsable> responsables = responsableService.getAllResponsables();
            if (responsables.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(responsables);
            }
        }

        @GetMapping("/{id}")
        public ResponseEntity<Responsable> getResponsableById(@PathVariable Long id) {
            Optional<Responsable> responsable = responsableService.getResponsableById(id);
            if (responsable.isPresent()) {
                return ResponseEntity.ok(responsable.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }


        @PostMapping("/")
        public ResponseEntity<Responsable> createResponsable(@RequestBody Responsable responsable) {
            Responsable savedResponsable = responsableService.createResponsable(responsable);
            return ResponseEntity.status(HttpStatus.CREATED).body(responsable);
        }

        @PutMapping("/update")
        public ResponseEntity<Responsable> updateResponsable(@RequestBody @Valid ResponsableDto responsable) {
            Responsable updatedResponsable=responsableService.updateResponsable(responsable);
            if (updatedResponsable!=null) {

                return ResponseEntity.ok(updatedResponsable);
            } else {
                return ResponseEntity.notFound().build();
            }
        }


        @PutMapping("/Approve/{id}")

        public ResponseEntity<Void> approveResponsableById(@PathVariable Long id) {

            if (responsableService.approveResponsableById(id)) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }


        @PutMapping("/Desapprove/{id}")

        public ResponseEntity<Void> desapproveResponsableById(@PathVariable Long id) {

            if (responsableService.desapproveResponsableById(id)) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }


}
