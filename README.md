# Atlas Commerce

Enterprise-grade e-commerce backend built with Java and modern backend technologies.

## Overview

Atlas Commerce is a software engineering project focused on building a scalable and professional backend system while applying industry practices and modern architecture concepts.

This project aims to demonstrate:

- Backend engineering skills
- Software architecture knowledge
- REST API design
- Security principles
- Testing strategies
- Scalable system design
- Cloud and DevOps practices

---

## Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- Maven

### Database
- PostgreSQL

### Planned Technologies
- Redis
- RabbitMQ
- Docker
- Kubernetes
- JUnit 5
- Mockito
- Testcontainers
- CI/CD

---

## Project Structure

```text
src/main/java/com/example/atlascommerce

├── products
│   ├── controller
│   ├── service
│   ├── repository
│   ├── domain
│   ├── dto
│   └── mapper
│
├── shared
│   ├── config
│   ├── exception
│   └── utils
```

---

## Development Workflow

Branch strategy:

```text
main
develop

feature/*
fix/*
docs/*
refactor/*
test/*
```

Commit convention:

```text
feat: new feature
fix: bug fix
docs: documentation
refactor: code improvements
test: tests
chore: maintenance
```

---

## Running the Project

Clone repository:

```bash
git clone https://github.com/YOUR_USERNAME/atlas-commerce.git
```

Start database:

```bash
docker compose up -d
```

Run application:

```bash
./mvnw spring-boot:run
```

Application:

```text
http://localhost:8080
```

---

## Status

Project in active development.

Current phase:

Backend Foundation