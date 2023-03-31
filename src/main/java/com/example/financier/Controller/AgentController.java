package com.example.financier.Controller;



import com.example.financier.DTO.AgentDTO;

import com.example.financier.Model.Agent;
import com.example.financier.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    AgentService agentService;


    @GetMapping
    public ResponseEntity<List<Agent>> getAllAgents() {
        List<Agent> agents = agentService.getAllAgents();
        if (agents.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(agents);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agent> getAgentById(@PathVariable Long id) {
        Optional<Agent> agent = agentService.getAgentById(id);
        if (agent.isPresent()) {
            return ResponseEntity.ok(agent.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/")
    public ResponseEntity<Agent> createAgent(@RequestBody AgentDTO agent) {
        Agent savedAgent = agentService.createAgent(agent);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAgent);
    }

    @PutMapping("/update")
    public ResponseEntity<Agent> updateAgent(@RequestBody @Valid AgentDTO agent) {
        Agent updatedAgent=agentService.updateAgent(agent);
        if (updatedAgent!=null) {

            return ResponseEntity.ok(updatedAgent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/Approve/{id}")

    public ResponseEntity<Void> approveAgentById(@PathVariable Long id) {

        if (agentService.approveAgentById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/Desapprove/{id}")

    public ResponseEntity<Void> desapproveAgentById(@PathVariable Long id) {

        if (agentService.desapproveAgentById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
