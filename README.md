# Spring Boot Microservice Template

A production-ready Spring Boot microservice template with CI/CD pipeline, multi-environment support, and security best practices.

## Features

- **Spring Boot 3.5.6** with Java 21
- **Spring Data JPA** + **Flyway** for database management
- **PostgreSQL** (prod/staging) / **H2** (dev/test)
- **Actuator** + custom database health check
- **Swagger/OpenAPI** for API documentation
- **CORS** configured per environment
- **Lombok** for cleaner code
- **Testcontainers** for integration testing
- **GitHub Actions** CI/CD with Test, Checkstyle, JaCoCo
- **Multi-stage Docker** build

## Quick Start

### 1. Clone and Setup

```bash
git clone <this-repo>
cd microservice-template
cp src/main/resources/env.dev.properties.template src/main/resources/.env.properties
```

### 2. Customize

- Update `pom.xml`: `groupId`, `artifactId`, `name`, `description`
- Rename package from `com.template.microservice` to your own

### 3. Run

```bash
./mvnw spring-boot:run
```

### 4. Access

- Health: `http://localhost:8080/actuator/health`
- Swagger: `http://localhost:8080/swagger-ui.html`
- H2 Console: `http://localhost:8080/h2-console`

## Environment Profiles

| Profile | Database | CORS | Logging | Use Case |
|---------|----------|------|---------|----------|
| **dev** | H2 | `*` | DEBUG | Local development |
| **test** | H2 memory | `*` | WARN | Unit/Integration tests |
| **prod** | PostgreSQL | Strict | WARN | Production |

## Configuration

### Environment Configuration

**Local Development:**
- Copy `env.dev.properties.template` to `.env.properties`
- Uses H2 in-memory database

**Production:**
- Environment variables injected via Kubernetes

### Key Variables

**Development:**
```properties
APP_NAME=microservice-template-dev
PORT=8080
DB_URL=jdbc:h2:mem:testdb
```

**Production/Staging (Kubernetes):**
```yaml
# Example ConfigMap/Secrets
env:
  - name: PORT
    value: "8080"
  - name: DB_HOST
    value: "postgres-service"
  - name: DB_PORT
    value: "5432"
  - name: DB_NAME
    value: "microservice_prod"
  - name: DB_USERNAME
    valueFrom:
      secretKeyRef:
        name: db-secret
        key: username
  - name: DB_PASSWORD
    valueFrom:
      secretKeyRef:
        name: db-secret
        key: password
  - name: CORS_ALLOWED_ORIGINS
    value: "https://prod-app.example.com"
  - name: CORS_ALLOW_CREDENTIALS
    value: "false"
```

## Development

### Commands

```bash
# Run with profile
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

# Run tests
./mvnw test

# Build
./mvnw clean package

# Code quality
./mvnw checkstyle:check
./mvnw jacoco:report
```

## Docker

### Build & Run

```bash
docker build -t microservice-template .

docker run -p 8080:8080 \
  -e DB_HOST=postgres \
  -e DB_NAME=mydb \
  -e DB_USERNAME=user \
  -e DB_PASSWORD=password \
  -e CORS_ALLOWED_ORIGINS=https://app.example.com \
  microservice-template
```

## CI/CD

### Pipeline Includes

- ✅ Linting (Checkstyle)
- ✅ Testing with coverage (JaCoCo)
- ✅ Maven build
- ✅ Docker build & push to GitHub Container Registry

### Setup

1. **Settings → Actions → General**
2. Enable **"Read and write permissions"**

## Project Structure

```
src/main/
├── java/com/template/microservice/
│   ├── MicroserviceApplication.java
│   ├── config/
│   │   └── CorsConfig.java
│   └── health/
│       └── DatabaseHealthIndicator.java
└── resources/
    ├── application.yml                     # Base config
    ├── application-dev.yml                 # Development
    ├── application-test.yml                # Testing
    ├── application-prod.yml                # Production
    ├── env.dev.properties.template         # Dev env template
    └── db/migration/
        └── V1__Initial_schema.sql          # Flyway migration
```