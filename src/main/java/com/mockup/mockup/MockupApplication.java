package com.mockup.mockup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.event.EventListener;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.yaml.snakeyaml.Yaml;

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
@EnableEurekaServer
public class MockupApplication {

	private Path vaultPropertiesPath = Path.of("/opt/sec-configuration.yml");

	@EventListener(ApplicationReadyEvent.class)
	public void testing() throws IOException {
		readSecrets();
	}

	public static void main(String[] args) {
		SpringApplication.run(MockupApplication.class, args);
	}

	public void readSecrets() throws IOException {
		InputStream vaultPropertiesStream = Files.newInputStream(vaultPropertiesPath);
		Map vaultPropertiesMap = new Yaml().loadAs(vaultPropertiesStream, Map.class);
//		String test = vaultPropertiesMap.get("password").toString();
//		System.out.println(test);
	}

}
