package com.mockup.mockup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableFeignClients
@RefreshScope
@EntityScan
@SpringBootApplication
@EnableAsync
@EnableDiscoveryClient
public class Application {

	DiscoveryClient discoveryClient;

	public Application(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void testing() {

		int size = discoveryClient.getServices().size();
		System.out.println("Starting EventListener when ApplicationReadyEvent !!!");
		System.out.println("Kubernetes services size " + size);
		discoveryClient.probe();
		for (String service : discoveryClient.getServices()) {
			System.out.println("Discovered service " + service);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
