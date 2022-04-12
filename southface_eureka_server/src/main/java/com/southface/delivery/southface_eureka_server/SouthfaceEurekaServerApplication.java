package com.southface.delivery.southface_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SouthfaceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SouthfaceEurekaServerApplication.class, args);
	}

}