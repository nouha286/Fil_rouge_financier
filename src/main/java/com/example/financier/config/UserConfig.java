package com.example.financier.config;




import com.example.financier.Model.Role;
import com.example.financier.Repository.RoleRepository;
import com.example.financier.Repository.UserRepository;
import com.example.financier.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
  
    @Bean
    CommandLineRunner commandLineRunner1 (UserServiceImpl userService){
        return args -> {

            Role role=new Role("ADMIN");
            Role role1=new Role("RESPONSABLE");
            Role role2=new Role("AGENT");
            roleRepository.saveAll(List.of(role1,role2,role));


/*          userService.addRoleToUser("hiba@gmail.com","FOURNISSEUR");
            userService.addRoleToUser("ismail@gmail.com","STOCK_MANAGER");
            userService.addRoleToUser("nouhaila@gmail.com","CLIENT");*/


        };
    }
}
