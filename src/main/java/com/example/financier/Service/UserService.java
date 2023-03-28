package com.example.financier.Service;

import com.example.financier.Model.Role;
import com.example.financier.Model.User;

public interface UserService {

    public Role saveRole(Role role);
    public void addRoleToUser(String email, String roleName);

    public User saveUser(User user);
}
