# Multi-Utility Calculator

A full-stack web application that bundles several everyday calculators — Basic arithmetic, BMI, Age, EMI, GST, Percentage, and Discount — behind a single dashboard, with calculation history saved to a database.

## Tech Stack

**Backend:** Java 17, Spring Boot 3, Spring Data JPA, MySQL (H2 for local/dev), Swagger/OpenAPI
**Frontend:** HTML5, CSS3, Vanilla JavaScript (fetch API)
**Deployment:** Docker, Docker Compose, Nginx (reverse proxy for the frontend)

## Features

- **Basic Calculator** — add, subtract, multiply, divide, and other simple operations
- **BMI Calculator** — Body Mass Index from height & weight, with category classification
- **Age Calculator** — exact age in years, months, and days from a date of birth
- **EMI Calculator** — loan EMI, total interest, and total payment
- **GST Calculator** — add/remove GST at a given rate
- **Percentage Calculator** — percentage of a value, percentage change, etc.
- **Discount Calculator** — final price and amount saved after a discount
- **History** — every calculation is persisted and can be viewed, filtered, and cleared

## Project Structure

```
Multi-Utility-Calculator/
├── database/        # SQL schema, sample data, useful queries
├── frontend/         # Static HTML/CSS/JS client
├── backend/           # Spring Boot REST API
├── deployment/       # Docker & Nginx config
└── docs/               # Project docs & screenshots
```

## Getting Started

### Prerequisites
- JDK 17+
- Maven 3.8+
- MySQL 8 (or use the bundled H2 in-memory DB for quick local runs)
- Node not required — frontend is static

### Run the backend

```bash
cd backend
mvn spring-boot:run
```

The API starts on `http://localhost:8080`. Swagger UI is available at `http://localhost:8080/swagger-ui.html`.

### Run the frontend

Serve the `frontend/` folder with any static file server, e.g.:

```bash
cd frontend
python3 -m http.server 5500
```

Then open `http://localhost:5500`.

### Run with Docker Compose

```bash
cd deployment
docker-compose up --build
```

This spins up MySQL, the Spring Boot backend, and an Nginx server for the frontend.

## API Overview

| Endpoint | Method | Description |
|---|---|---|
| `/api/basic/calculate` | POST | Perform a basic arithmetic operation |
| `/api/bmi/calculate` | POST | Calculate BMI and category |
| `/api/age/calculate` | POST | Calculate age from date of birth |
| `/api/emi/calculate` | POST | Calculate loan EMI |
| `/api/gst/calculate` | POST | Add/remove GST |
| `/api/percentage/calculate` | POST | Percentage operations |
| `/api/history` | GET | Fetch calculation history |
| `/api/history/{id}` | DELETE | Delete a history entry |
| `/api/history` | DELETE | Clear all history |

## License

This project is provided as-is for educational purposes.
