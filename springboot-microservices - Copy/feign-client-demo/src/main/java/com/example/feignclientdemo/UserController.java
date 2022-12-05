package com.example.feignclientdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")

public class UserController {
    @GetMapping("/username")
    public String getUserName() {
        return "John";
    }

    @GetMapping("/password")
    public String getPassword(){
        return "John123";
        }
        @GetMapping("/validate_user")
        public Boolean isUserLoggedIn(){
            return true;
        }
    }

