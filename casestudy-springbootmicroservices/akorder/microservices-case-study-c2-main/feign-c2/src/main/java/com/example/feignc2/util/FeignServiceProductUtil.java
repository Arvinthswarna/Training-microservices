package com.example.feignc2.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "product-service-c2",url = "http://localhost:3001/products")
public interface FeignServiceProductUtil {

    @GetMapping("/Products")
    String getProdId();
}
