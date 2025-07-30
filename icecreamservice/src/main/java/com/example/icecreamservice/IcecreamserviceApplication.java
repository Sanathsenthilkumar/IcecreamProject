package com.example.icecreamservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class IcecreamserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcecreamserviceApplication.class, args);
	}

}
