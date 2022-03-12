package com.southface.delivery.southface_delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SouthfaceDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SouthfaceDeliveryApplication.class, args);
	}

}
