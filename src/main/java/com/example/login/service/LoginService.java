package com.example.login.service;

import com.example.login.entity.Login;
import com.example.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {


    @Autowired
    private LoginRepository loginRepository;

    private PasswordEncoder encoder = new BCryptPasswordEncoder(8);

    public String newUserLogin(String username, String password) {
        Login ExUser = loginRepository.findByUsername(username);
        if(ExUser!= null){

       return "User already exists";
        }
        Login newUser = new Login();
        newUser.setUsername(username);
        newUser.setPassword(encoder.encode(password));
        newUser.setRole("USER"); // Default role for the new user, can be modified as needed

        loginRepository.save(newUser);
        return "User registered successfully";
    }

}

