package com.template.microservice;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the microservice template.
 */
@SpringBootApplication
public class MicroserviceApplication {

    /**
     * Main method to start the Spring Boot application.
     * @param args command line arguments
     */
    @Generated
    public static void main(final String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);
    }
}

