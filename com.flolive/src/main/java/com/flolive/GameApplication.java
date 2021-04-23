package com.flolive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.flolive.service",
		"com.flolive.question.provider",
		"com.flolive.controllers",
		"com.flolive.models",
		"com.manager"})
public class GameApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
	}

}
