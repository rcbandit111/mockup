package com.mockup.mockup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
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

	private Path vaultPropertiesPath = Path.of("/opt/sec-configuration.yml");

	@EventListener(ApplicationReadyEvent.class)
	public void testing() throws IOException {
		readSecrets();
	}

	public static void main(String[] args) {
		SpringApplication.run(MockupApplication.class, args);
	}

	Yaml yaml = new Yaml();

	public void readSecrets() throws IOException {
		try {
			// Replace "example.yml" with the path to your YAML file
			FileInputStream inputStream = new FileInputStream("/opt/sec-configuration.yml");
			// Load YAML file into a Map
			Map<String, Object> obj = yaml.load(inputStream);

			// Access values from the Map
			String value = (String) obj.get("password");
			System.out.println("Value from YAML: " + value);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
