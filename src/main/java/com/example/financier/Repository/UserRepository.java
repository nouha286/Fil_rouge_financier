package com.example.financier.Repository;

import com.example.financier.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
}
