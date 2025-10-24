package com.template.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the microservice template.
 */
@SpringBootApplication
public final class MicroserviceApplication {

    /**
     * Private constructor to prevent instantiation.
     */
    private MicroserviceApplication() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Main method to start the Spring Boot application.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);
    }
}
