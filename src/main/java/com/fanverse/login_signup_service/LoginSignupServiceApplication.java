package com.fanverse.login_signup_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories()
public class LoginSignupServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSignupServiceApplication.class, args);
	}

}
