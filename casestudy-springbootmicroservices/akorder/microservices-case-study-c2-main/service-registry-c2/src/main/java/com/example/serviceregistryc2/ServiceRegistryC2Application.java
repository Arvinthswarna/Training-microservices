package com.example.serviceregistryc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryC2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryC2Application.class, args);
	}

}
