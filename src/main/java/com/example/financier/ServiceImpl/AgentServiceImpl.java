package com.example.financier.ServiceImpl;

import com.example.financier.DTO.AgentDTO;
import com.example.financier.Model.Agence;
import com.example.financier.Model.Agent;
import com.example.financier.Model.Etat;
import com.example.financier.Repository.AgentRepository;
import com.example.financier.Repository.RoleRepository;
import com.example.financier.Service.AgenceService;
import com.example.financier.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    AgentRepository agentRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AgenceService agenceService;

    public List<Agent> getAllAgents()
    {
        return agentRepository.findAll();
    }
    @Override
    public Agent createAgent(AgentDTO agentDto) {
         Agent agent=convertAgentDtoToAgent(agentDto);
         if (agent!=null)
         {
             return agentRepository.save(agent);
         }
        return agent;
    }

    @Override
    public Optional<Agent> getAgentById(Long agentId) {
        return agentRepository.findById(agentId);
    }

    @Override
    public Agent updateAgent(AgentDTO agentDetails) {
        Optional<Agent> agentUpdated=agentRepository.findById(agentDetails.getId());
        if (agentUpdated.isPresent())
        {
            if (agentDetails.getPassword()!=null) agentUpdated.get().setPassword(agentDetails.getPassword());
            if (agentDetails.getEmail()!=null) agentUpdated.get().setEmail(agentDetails.getEmail());
            if (agentDetails.getAgenceId()!=null && agenceService.getAgenceById(agentDetails.getAgenceId()).isPresent()) agentUpdated.get().setAgence(agenceService.getAgenceById(agentDetails.getAgenceId()).get());
            if (agentDetails.getName()!=null) agentUpdated.get().setName(agentDetails.getName());
            return agentRepository.save(agentUpdated.get());
        }

        return null;
    }

    @Override
    public Boolean approveAgentById(Long id) {
        Optional<Agent> agent=agentRepository.findById(id);
        if (agent.isPresent())
        {
            agent.get().setEtat(Etat.Approuved);
            return true;
        }
        return false;
    }

    @Override
    public Boolean desapproveAgentById(Long id) {
        Optional<Agent> agent=agentRepository.findById(id);
        if (agent.isPresent())
        {
            agent.get().setEtat(Etat.refused);
            return true;
        }
        return false;
    }

    public Agent convertAgentDtoToAgent(AgentDTO agentDTO)
    {

        Optional<Agence> agence=agenceService.getAgenceById(agentDTO.getAgenceId());
        if (agence.isPresent())
        {
            Agent agent=new Agent();
            agent.setName(agentDTO.getName());
           agent.setEtat(Etat.refused);
           agent.setEmail(agentDTO.getEmail());
            agent.getRoles().add(roleRepository.findById(3L).get());
            agent.setPassword(agentDTO.getPassword());
            agent.setAgence(agence.get());
            return agent;
        }
        return null;
    }
}
