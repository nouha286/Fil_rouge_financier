package com.example.financier.Service.User;


import com.example.financier.Model.Role;
import com.example.financier.Model.User;
import com.example.financier.Repository.RoleRepository;
import com.example.financier.Repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service  @Transactional @Slf4j
public class UserServiceImpl implements UserDetailsService, UserService {


    @Autowired
    UserRepository userRepository;
@Autowired
RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user=userRepository.findUserByEmail(email);
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getNameRole()));
        });
    return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }
   public User saveUser(User user){
        user.setPassword(NoOpPasswordEncoder.getInstance().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Role saveRole(Role role)
    {
        return roleRepository.save(role);
    }


    @Transactional
    public void addRoleToUser(String email, String roleName)
    {
        User user=userRepository.findUserByEmail(email);
        Role role=roleRepository.findRoleByNameRole(roleName);
        user.getRoles().add(role);

    }

   public User getUser(String email)
    {
        return userRepository.findUserByEmail(email);

    }
   public List<User>  getUsers()
    {
        return userRepository.findAll();
    }


}
