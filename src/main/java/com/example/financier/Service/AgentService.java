package com.example.financier.Service;

import com.example.financier.DTO.AgentDTO;
import com.example.financier.Model.Agent;

import java.util.List;
import java.util.Optional;

public interface AgentService {

    public  Agent createAgent(AgentDTO agent);
    public Optional<Agent> getAgentById(Long agentId);
    public Agent updateAgent(  AgentDTO agentDetails);
    Boolean approveAgentById(Long id);
    Boolean desapproveAgentById(Long id);

    public List<Agent> getAllAgents();

}
