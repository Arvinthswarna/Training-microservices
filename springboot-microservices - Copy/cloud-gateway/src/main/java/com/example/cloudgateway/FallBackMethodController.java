package com.example.cloudgateway;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FallBackMethodController {
    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer time than Expected." + "please try again later";
    }

    @GetMapping("/productServiceFallBack")
    public String productServiceFallBackMethod() {
        return "User Service is taking longer time than Expected." + "please try again later";
    }
}