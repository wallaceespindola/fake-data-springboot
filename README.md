![Java](https://cdn.icon-icons.com/icons2/2699/PNG/512/java_logo_icon_168609.png)

# Fake Data API - Spring Boot Demo

![Apache 2.0 License](https://img.shields.io/badge/License-Apache2.0-orange)
![Java](https://img.shields.io/badge/Built_with-Java21-blue)
![Junit5](https://img.shields.io/badge/Tested_with-Junit5-teal)
![Spring](https://img.shields.io/badge/Structured_by-SpringBoot-lemon)
![Maven](https://img.shields.io/badge/Powered_by-Maven-pink)
![Swagger](https://img.shields.io/badge/Docs_by-Swagger-yellow)
![OpenAPI](https://img.shields.io/badge/Specs_by-OpenAPI-purple)
[![CI](https://github.com/wallaceespindola/structured-comm-full/actions/workflows/ci.yml/badge.svg)](https://github.com/wallaceespindola/fake-data-springboot/actions/workflows/ci.yml)

## Introduction

A compact Java 21 / Spring Boot project showcasing **Datafaker** + **Easy Random** to generate fake users.

Includes Swagger UI, Actuator with timestamp, Docker, CI, Dependabot, tests,
Postman, and a static tester page.

Contains a static **index.html** to try it out, unit tests, a Postman collection, and **Swagger UI / OpenAPI** docs.

## Tech

- Java 21
- Spring Boot 3 (Web, Actuator)
- springdoc-openapi (Swagger UI)
- Maven, DevTools
- JUnit 5

## Run

```bash
mvn spring-boot:run
```

Open:

- `http://localhost:8080/` (Test UI)
- `http://localhost:8080/swagger-ui.html` (Swagger UI)
- `http://localhost:8080/v3/api-docs` (OpenAPI JSON)

## Docker

Build the image (multi-stage Dockerfile):

```bash
docker build -t fake-data-springboot:latest .
```

Run the container:

```bash
docker run --rm -p 8080:8080 --name fake-data-api fake-data-springboot:latest
```

Open:

- `http://localhost:8080/`
- `http://localhost:8080/swagger-ui.html`

## Docker Compose

Use the provided `docker-compose.yml` to build and run:

```bash
docker compose up --build
# or (detached)
docker compose up --build -d
```

Stop and remove resources:

```bash
docker compose down
```

## Notes

- Health endpoint exposes details with `management.endpoint.health.show-details=always` and adds a `timestamp` via a
  custom `HealthIndicator`.

## Author

- Wallace Espindola, Sr. Software Engineer / Solution Architect / Java & Python Dev
- **LinkedIn:** [linkedin.com/in/wallaceespindola/](https://www.linkedin.com/in/wallaceespindola/)
- **GitHub:** [github.com/wallaceespindola](https://github.com/wallaceespindola)
- **E-mail:** [wallace.espindola@gmail.com](mailto:wallace.espindola@gmail.com)
- **Twitter:** [@wsespindola](https://twitter.com/wsespindola)
- **Gravatar:** [gravatar.com/wallacese](https://gravatar.com/wallacese)
- **Dev Community:** [dev.to/wallaceespindola](https://dev.to/wallaceespindola)
- **DZone Articles:** [DZone Profile](https://dzone.com/users/1254611/wallacese.html)
- **Pulse Articles:** [LinkedIn Articles](https://www.linkedin.com/in/wallaceespindola/recent-activity/articles/)
- **Website:** [W-Tech IT Solutions](https://www.wtechitsolutions.com/)
- **Slides:** [Speakerdeck](https://speakerdeck.com/wallacese)

## License

- This project is released under the Apache 2.0 License.
- See the [LICENSE](LICENSE) file for details.
- Copyright © 2025 [Wallace Espindola](https://github.com/wallaceespindola/).