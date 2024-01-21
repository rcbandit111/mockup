package com.mockup.mockup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MockupApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockupApplication.class, args);
	}

}
