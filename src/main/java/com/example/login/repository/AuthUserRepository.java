package com.example.login.repository;


import com.example.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String username);
}
