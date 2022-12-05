package com.example.demo.controller;

import com.example.demo.entity.UserOne;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public UserOne saveUser(@RequestBody UserOne user){
        return userService.saveUser(user);
    }
    @GetMapping("/fetch/{id}")
    public UserOne findUserById( @PathVariable("id") Long userId){
        return userService.findUserById(userId);

    }
}

