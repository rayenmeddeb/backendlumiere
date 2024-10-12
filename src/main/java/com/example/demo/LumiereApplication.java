package com.example.demo;

import java.util.Arrays;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableScheduling
public class LumiereApplication {

	public static void main(String[] args) {
		SpringApplication.run(LumiereApplication.class, args);
		
		
		
	}
	
	@Bean

	public CorsFilter corsFilter() {

	CorsConfiguration corsConfiguration = new CorsConfiguration();

	UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();


	corsConfiguration.setAllowCredentials(true);

	corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://18.209.167.231"));

	corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",

	"Accept","Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",

	"Access-Control-Request-Method", "Access-Control-Request-Headers"));

	corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept","Jwt-Token", "Authorization",

	"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));

	corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

	urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

	return new CorsFilter(urlBasedCorsConfigurationSource);
	}

	
	
}
