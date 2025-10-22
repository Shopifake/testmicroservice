# Spring Boot Microservice Template

Clean Spring Boot microservice template with essential dependencies and CI/CD.

## Features

- Spring Boot 3.5.6 + Java 21
- Lombok, Validation, Actuator, Data JPA
- H2 Database + Testcontainers
- JaCoCo, SpotBugs, Checkstyle
- Docker + GitHub Actions CI/CD

## Quick Start

1. Use this template to create a new repo
2. Update `pom.xml` with your project details
3. Rename `MicroserviceApplication.java`
4. Start coding!

## Run

```bash
./mvnw spring-boot:run
```

## Docker

```bash
docker build -t your-service .
docker run -p 8080:8080 your-service
```
