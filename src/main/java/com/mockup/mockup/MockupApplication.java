package com.mockup.mockup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.event.EventListener;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SpringBootApplication
public class MockupApplication {

	DiscoveryClient discoveryClient;

	public MockupApplication(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void testing() throws IOException {

		int size = discoveryClient.getServices().size();
		System.out.println("Starting EventListener when ApplicationReadyEvent !!!");
		System.out.println("Kubernetes services size " + size);
		discoveryClient.probe();
		for (String service : discoveryClient.getServices()) {
			System.out.println("Discovered service " + service);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(MockupApplication.class, args);
	}
}
