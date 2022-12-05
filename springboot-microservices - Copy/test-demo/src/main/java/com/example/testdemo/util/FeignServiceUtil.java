package com.example.testdemo.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "feignDemo",url="http://localhost:3000/users")

public interface FeignServiceUtil {

    @GetMapping("/username")
    String getUserName();

    @GetMapping("/password")
    String getPassword();

    @GetMapping("/validate_user")
    Boolean getUserValidation();
}
