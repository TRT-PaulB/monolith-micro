package com.rollingstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class RollingstoneEcommerceRemoteConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RollingstoneEcommerceRemoteConfigServiceApplication.class, args);
	}
}
