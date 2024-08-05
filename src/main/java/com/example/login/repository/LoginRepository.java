package com.example.login.repository;

import com.example.login.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUsername(String username);
}

