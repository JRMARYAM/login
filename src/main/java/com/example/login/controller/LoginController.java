
package com.example.login.controller;

import com.example.login.dto.UserDto;
import com.example.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/loginUser")
    public String saveUser(@RequestBody UserDto dto){
        return loginService.newUserLogin(dto.getUsername(), dto.getPassword());
    }
@PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String getUser() {
        return "hello";
    }

    @GetMapping("/manager")
    public String getManager() {
        return "hi";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }
}
