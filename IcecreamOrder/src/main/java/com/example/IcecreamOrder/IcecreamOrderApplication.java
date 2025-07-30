package com.example.IcecreamOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class IcecreamOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcecreamOrderApplication.class, args);
	}

}
