package com.example.testdemo.controller;

import com.example.testdemo.util.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")

public class FeignDemoController {
    @Autowired
    private FeignServiceUtil feignServiceUtil;

    @GetMapping("/username")
    public String getUserName(){
        return "Hello !!! " + feignServiceUtil.getUserName();
    }
    @GetMapping("/password")
    public String getPassword(){
        return feignServiceUtil.getPassword();


    }
}
