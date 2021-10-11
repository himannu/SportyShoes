package com.simplilearn.sportyshoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SportyshoesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SportyshoesApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SportyshoesApplication.class);
	}
	
	
}
