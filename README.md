# Spring Boot Microservice Template

A production-ready Spring Boot microservice template with CI/CD pipeline, multi-environment support, and security best practices.

## Features

- **Spring Boot 3.5.6** with Java 21
- **Spring Data JPA** + **Flyway** for database management
- **PostgreSQL** (prod/staging) / **H2** (dev/test)
- **Actuator** for health monitoring
- **Swagger/OpenAPI** for API documentation
- **CORS** configured per environment
- **Lombok** for cleaner code
- **Testcontainers** for integration testing
- **GitHub Actions** CI/CD with Checkstyle, SpotBugs, JaCoCo
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
| **staging** | PostgreSQL | Strict | WARN | Pre-production |
| **prod** | PostgreSQL | Strict | WARN | Production |

## Configuration

### Environment Templates

| File | Database | Use Case |
|------|----------|----------|
| `env.dev.properties.template` | H2 | Local development |
| `env.staging.properties.template` | PostgreSQL | Staging |
| `env.prod.properties.template` | PostgreSQL | Production |

### Key Variables

**Development:**
```properties
APP_NAME=microservice-template-dev
PORT=8080
DB_URL=jdbc:h2:mem:testdb
```

**Production:**
```properties
APP_NAME=microservice-template
PORT=8080
DB_HOST=prod-db.example.com
DB_PORT=5432
DB_NAME=microservice_prod
DB_USERNAME=prod_user
DB_PASSWORD=SECURE_PASSWORD
CORS_ALLOWED_ORIGINS=https://prod-app.example.com
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
./mvnw spotbugs:check
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

- ✅ Linting (Checkstyle, SpotBugs)
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
│   └── config/
│       └── CorsConfig.java
└── resources/
    ├── application.yml                     # Base config
    ├── application-dev.yml                 # Development
    ├── application-test.yml                # Testing
    ├── application-staging.yml             # Staging
    ├── application-prod.yml                # Production
    ├── env.dev.properties.template         # Dev env
    ├── env.staging.properties.template     # Staging env
    ├── env.prod.properties.template        # Prod env
    └── db/migration/
        └── V1__Initial_schema.sql          # Flyway migration
```