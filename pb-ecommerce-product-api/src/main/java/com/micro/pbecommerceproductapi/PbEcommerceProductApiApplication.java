package com.micro.pbecommerceproductapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PbEcommerceProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbEcommerceProductApiApplication.class, args);
	}

}
