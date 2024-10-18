package com.example.service_registry_ef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryEfApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryEfApplication.class, args);
	}

}
