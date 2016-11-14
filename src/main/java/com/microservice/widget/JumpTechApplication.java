package com.microservice.widget;

import org.springframework.boot.SpringApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class JumpTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(JumpTechApplication.class, args);
	}
}
