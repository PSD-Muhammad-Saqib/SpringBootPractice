package com.practice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootPracticeApplication {

	public static void main(String[] args) {
		//	psql -U postgres -d springboot
		SpringApplication.run(SpringBootPracticeApplication.class, args);
	}

}
