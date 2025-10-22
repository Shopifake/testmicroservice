package com.example.microservice;

import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the microservice template.
 */
@SpringBootApplication
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class MicroserviceApplication {

    /**
     * Main method to start the Spring Boot application.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);
    }
}