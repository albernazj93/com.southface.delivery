package com.southface.delivery.southface_delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SouthfaceDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SouthfaceDeliveryApplication.class, args);
	}

}
