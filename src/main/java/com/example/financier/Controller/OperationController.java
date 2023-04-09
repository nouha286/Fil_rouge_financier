package com.example.financier.Controller;

import com.example.financier.DTO.OperationDto;
import com.example.financier.Model.Operation;
import com.example.financier.Service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    OperationService operationService;

    @PostMapping("/deposer")
    public ResponseEntity<Operation> deposer(@RequestBody OperationDto operationDto) {
        Operation operation = operationService.deposer(operationDto);

        if (operation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(operation, HttpStatus.CREATED);
    }

    @PostMapping("/retirer")
    public ResponseEntity<Operation> retirer(@RequestBody OperationDto operationDto) {
        Operation operation = operationService.retirer(operationDto);
        if (operation!=null){

            return new ResponseEntity<>(operation, HttpStatus.CREATED);
        } else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Operation>> getAllOperations() {
        List<Operation> operations = operationService.getAllOperations();
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }

    @GetMapping("/compte/{compteId}")
    public ResponseEntity<List<Operation>> getOperationsByCompte(@PathVariable Long compteId) {
        List<Operation> operations = operationService.getOperationsByCompte(compteId);

        if (operations == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(operations, HttpStatus.OK);
    }

    @PostMapping("/transferer")
    public ResponseEntity<Operation> transferer(@RequestBody OperationDto operationDto) {
        Operation operation = operationService.transferer(operationDto);
        if (operation != null) {
            return ResponseEntity.ok(operation);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

