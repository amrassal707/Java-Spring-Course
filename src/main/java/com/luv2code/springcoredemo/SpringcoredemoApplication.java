package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
Spring Boot @SpringBootApplication annotation is used to mark a
configuration class that declares one or more @Bean methods and also triggers
auto-configuration and component scanning. It's same as declaring a class with @Configuration,
@EnableAutoConfiguration and @ComponentScan annotations

autoconfigure,  configures the app based on the mavin dependencies while running the app
 */
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
