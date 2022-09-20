package com.rental.securityjwtservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SecurityJwtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityJwtServiceApplication.class, args);
	}

}
