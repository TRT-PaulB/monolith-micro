package com.micro.pbecommerceremoteconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PbEcommerceRemoteConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbEcommerceRemoteConfigServiceApplication.class, args);
	}

}
