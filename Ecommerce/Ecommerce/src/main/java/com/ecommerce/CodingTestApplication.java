package com.ecommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ecommerce.datarepository"})

public class CodingTestApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CodingTestApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("REST API Application - Digia Coding Test started...");
		
		SpringApplication.run(CodingTestApplication.class, args);
		
	}

}
