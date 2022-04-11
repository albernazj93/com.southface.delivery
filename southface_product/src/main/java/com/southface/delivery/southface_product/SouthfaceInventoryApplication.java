package com.southface.delivery.southface_product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SouthfaceInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SouthfaceInventoryApplication.class, args);
	}

}