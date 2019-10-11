package com.rollingstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RollingstoneEcommerceCartApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RollingstoneEcommerceCartApiApplication.class, args);
	}
}
