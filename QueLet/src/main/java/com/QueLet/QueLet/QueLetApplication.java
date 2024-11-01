package com.QueLet.QueLet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class QueLetApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueLetApplication.class, args);
	}
}