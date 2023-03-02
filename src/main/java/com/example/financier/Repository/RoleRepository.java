package com.example.financier.Repository;

import com.example.financier.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByNameRole(String roleName);
}
