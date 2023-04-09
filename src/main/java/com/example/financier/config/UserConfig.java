package com.example.financier.config;




import com.example.financier.DTO.AgentDTO;
import com.example.financier.Model.*;
import com.example.financier.Repository.AdminRepository;
import com.example.financier.Repository.RoleRepository;
import com.example.financier.Repository.UserRepository;
import com.example.financier.Service.AgentService;
import com.example.financier.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class UserConfig {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AgentService agentService;
    @Autowired
    AdminRepository adminRepository;
  
    @Bean
    CommandLineRunner commandLineRunner1 (UserServiceImpl userService){
        return args -> {

            Role role=new Role("ADMIN");
            Role role1=new Role("RESPONSABLE");
            Role role2=new Role("AGENT");
            roleRepository.saveAll(List.of(role,role1,role2));
           Admin admin=new Admin();
           admin.setEmail("nouhaila@gmail.com");
           admin.setName("nouhaila");
           admin.setPassword("azuzae");
            Optional<Role> role0=roleRepository.findById(1L);
           List<Role> roles=new ArrayList<Role>();
           roles.add(role0.get());
           admin.setRoles(roles);
           adminRepository.save(admin);



/*          userService.addRoleToUser("hiba@gmail.com","FOURNISSEUR");
            userService.addRoleToUser("ismail@gmail.com","STOCK_MANAGER");
            userService.addRoleToUser("nouhaila@gmail.com","CLIENT");*/


        };
    }
}
