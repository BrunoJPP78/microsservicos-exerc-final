package com.example.api_gateway_ef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayEfApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayEfApplication.class, args);
	}

}
