package com.nse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryUdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryUdApplication.class, args);
	}

}
