package com.main.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * This is the main class of Spring Boot Application.
 */

@SpringBootApplication
@EnableScheduling
public class TransactionManagementApplication {

	private static Logger LOG = LoggerFactory.getLogger(TransactionManagementApplication.class);

	public static void main(String[] args) {

		LOG.info("Transaction Management Application is now up and runnig!");
		SpringApplication.run(TransactionManagementApplication.class, args);
	}
}