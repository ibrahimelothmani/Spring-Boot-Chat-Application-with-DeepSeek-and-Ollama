package com.ibrahim.LLM;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LlmApplication {

	private static final Logger logger = LoggerFactory.getLogger(LlmApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(LlmApplication.class, args);

		logger.info("LLM STARTED");
	}

}
