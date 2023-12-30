package com.luv2code.springboot.cruddemo;

import com.luv2code.springboot.cruddemo.entity.Employee;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api")
@SpringBootApplication
public class ServiceSecurityTest {
	@Autowired
	@Lazy
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


	public static final String USER_SERVICE="userService";

	private static final String BASEURL = "http://localhost:8080/api/readall";
	// expose "/employees" and return a list of employees
	@GetMapping("/Test")
	@CircuitBreaker(name = USER_SERVICE , fallbackMethod = "returnThis")
	// retry automtically tries multiple time with interval until it reaches nothing and then goes to the fallbackmethod
	//@Retry(name = USER_SERVICE, fallbackMethod = "returnThis")
	public List<Employee> findAll() {
		System.out.println("trying again");
		// performing a rest call
		return restTemplate.getForObject(BASEURL, ArrayList.class);
	}
	// only gets executed when an exception happens, as in a called service is down
	public List<Employee> returnThis (Exception be) {
		return Stream.of(
				new Employee("LED TV", "electronics", "white"),
				new Employee("LED TV", "electronics", "white")
		).collect(Collectors.toList());
	}


	public static void main(String[] args) {
		SpringApplication.run(ServiceSecurityTest.class, args);
	}

}
