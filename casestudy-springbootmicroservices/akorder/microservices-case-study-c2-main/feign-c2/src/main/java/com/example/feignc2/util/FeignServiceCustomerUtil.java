package com.example.feignc2.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "customer-service-c2",url = "http://localhost:3002/customers")
public interface FeignServiceCustomerUtil {

    @GetMapping("/Customers")
    String getCstId();
}
