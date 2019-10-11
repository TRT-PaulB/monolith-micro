package com.rollingstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RollingstoneEcommercePricingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RollingstoneEcommercePricingApiApplication.class, args);
	}
}
