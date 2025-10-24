# Spring Boot Microservice Template

A clean, production-ready Spring Boot microservice template with Spring Cloud Gateway, comprehensive CI/CD pipeline, and multiple environment profiles.

## Features

- **Spring Boot 3.5.6** with Java 21
- **Spring Cloud Gateway** for API routing
- **Actuator** for health checks and monitoring
- **Flyway** for database migrations
- **PostgreSQL** and **H2** database support
- **Swagger/OpenAPI** documentation
- **Lombok** for cleaner code
- **Testcontainers** for integration testing
- **Multi-stage Docker** build
- **GitHub Actions** CI/CD pipeline
- **Multiple profiles** (dev, test, staging, prod)

## Quick Start

1. **Clone and customize**:
   ```bash
   git clone <this-repo>
   cd microservice-template
   ```

2. **Update configuration**:
   - Copy `src/main/resources/env.properties.template` to `.env.properties.local`
   - Modify the environment variables as needed
   - Update `application.yml` files for your specific services

3. **Run locally**:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access endpoints**:
   - Health check: `http://localhost:8080/actuator/health`
   - API docs: `http://localhost:8080/swagger-ui.html`

## Environment Profiles

- **dev**: Development with H2 database
- **test**: Testing with H2 in-memory database
- **staging**: Staging with PostgreSQL
- **prod**: Production with PostgreSQL

## CI/CD Pipeline

The template includes a complete GitHub Actions pipeline with:
- Linting (Checkstyle, SpotBugs)
- Testing with coverage (JaCoCo)
- Docker build and push
- Multi-environment deployment

## Docker

```bash
# Build
docker build -t microservice-template .

# Run
docker run -p 8080:8080 microservice-template
```