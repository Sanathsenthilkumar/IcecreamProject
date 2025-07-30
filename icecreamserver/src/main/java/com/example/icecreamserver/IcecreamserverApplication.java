package com.example.icecreamserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class IcecreamserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcecreamserverApplication.class, args);
	}

}
