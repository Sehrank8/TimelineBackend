# Timeline

A Spring Boot application for managing and visualizing user listening events and timelines.

## Features
- User authentication with JWT
- Timeline generation and summary
- RESTful API endpoints
- OpenAPI (Swagger) documentation
- Secure endpoints with custom security configuration

## Project Structure
- `src/main/java/fizy/timeline/` - Main application source code
  - `controller/` - REST controllers
  - `service/` - Business logic
  - `dao/` - Data access objects
  - `entity/` - JPA entities and DTOs
  - `config/` - Configuration classes (OpenAPI, Security)
  - `security/` - JWT authentication filter and services
- `src/main/resources/` - Application properties, static files, templates
- `src/test/java/fizy/timeline/` - Test cases

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- Docker (optional, for containerization)

### Build & Run

#### Using Maven
```bash
./mvnw clean install
./mvnw spring-boot:run
```

#### Using Docker
```bash
docker build -t timeline .
docker run -p 8080:8080 timeline
```

### API Documentation
- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Configuration
Edit `src/main/resources/application.properties` to set up database and other properties.

## License
This project is licensed under the MIT License.
