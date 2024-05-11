package com.example.ProiectAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.ProiectAPI.repository")
@EntityScan(basePackages = "com.example.ProiectAPI.domain.model")
@RestController
@EnableWebMvc
public class ProiectApiApplication {

	public static void main(String[] args) {
		System.out.println("Spring Boot version: " + SpringBootVersion.getVersion());
		SpringApplication.run(ProiectApiApplication.class, args);
	}

	@Bean
	public InternalResourceViewResolver defaultViewResolver() {
		return new InternalResourceViewResolver();
	}
}


// Intrebare (ID, Text - string, variantaa, VARIAntab, variantac - stringuri, varianta-corecta- string   || add, delete, get
// Chestionar - ID, List<Interbari> || add, delete, get
// Attemp - ID, User, Chestionar, DateTime, PunctajObtinut || add, get