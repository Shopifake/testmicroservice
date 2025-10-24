# Spring Boot Microservice Template

A clean, production-ready Spring Boot microservice template with comprehensive CI/CD pipeline and multiple environment profiles.

## Features

- **Spring Boot 3.5.6** with Java 21
- **Spring Data JPA** for database access
- **PostgreSQL** for production, **H2** for development/testing
- **Flyway** for database migrations
- **Actuator** for health checks and monitoring
- **Swagger/OpenAPI** documentation
- **Lombok** for cleaner code
- **Testcontainers** for integration testing
- **Multi-stage Docker** build
- **GitHub Actions** CI/CD pipeline with Checkstyle, SpotBugs, JaCoCo
- **Multiple profiles** (dev, test, staging, prod)

## Quick Start

1. **Clone and customize**:
   ```bash
   git clone <this-repo>
   cd microservice-template
   ```

2. **Update configuration**:
   - Copy `src/main/resources/env.properties.template` to `.env.properties`
   - Modify the environment variables as needed
   - Update `pom.xml` with your project details (groupId, artifactId)

3. **Run locally**:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access endpoints**:
   - Health check: `http://localhost:8080/actuator/health`
   - API docs: `http://localhost:8080/swagger-ui.html`
   - H2 Console (dev): `http://localhost:8080/h2-console`

## Environment Profiles

- **default**: Base configuration with H2 database
- **dev**: Development with H2, detailed logging, hot reload
- **test**: Testing with H2 in-memory, random port
- **staging**: Staging with PostgreSQL, moderate logging
- **prod**: Production with PostgreSQL, minimal logging, security hardened

## Configuration

Each profile can be configured via environment variables:

```bash
# Application
APP_NAME=microservice-template
PORT=8080

# Database
DB_HOST=localhost
DB_PORT=5432
DB_NAME=mydb
DB_USERNAME=user
DB_PASSWORD=password
```

## CI/CD Pipeline

The template includes a complete GitHub Actions pipeline with:
- Linting (Checkstyle, SpotBugs)
- Testing with coverage (JaCoCo)
- Docker build and push to GitHub Container Registry
- Multi-environment deployment support

## Docker

```bash
# Build
docker build -t microservice-template .

# Run
docker run -p 8080:8080 \
  -e DB_HOST=postgres \
  -e DB_NAME=mydb \
  microservice-template
```

## Development

```bash
# Run tests
./mvnw test

# Run with specific profile
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

# Build
./mvnw clean package
```