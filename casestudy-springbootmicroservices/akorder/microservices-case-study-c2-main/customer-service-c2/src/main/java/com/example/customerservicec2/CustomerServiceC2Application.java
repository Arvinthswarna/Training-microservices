package com.example.customerservicec2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerServiceC2Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceC2Application.class, args);
	}

}
