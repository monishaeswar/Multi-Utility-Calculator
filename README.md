# 🧮 Multi-Utility Calculator

A full-stack web application that brings multiple everyday calculators into one place. The application provides calculators for basic arithmetic, BMI, age, EMI, GST, percentage, and discounts, with calculation history stored in a PostgreSQL database.

This project was developed as a **mini project** to gain practical experience in full-stack Java development, REST API integration, database connectivity, Git/GitHub, and cloud deployment.

---

## 🚀 Live Application

**Frontend:**
[Add your Vercel URL here]

**Backend API:**
[Add your Render backend URL here]

**GitHub Repository:**
[Add your GitHub repository URL here]

---

## ✨ Features

### ➕ Basic Calculator

Perform common arithmetic operations:

* Addition
* Subtraction
* Multiplication
* Division
* Other supported basic operations

### ⚖️ BMI Calculator

Calculate Body Mass Index using:

* Height
* Weight
* BMI value
* BMI category

### 🎂 Age Calculator

Calculate exact age based on date of birth:

* Years
* Months
* Days

### 🏦 EMI Calculator

Calculate loan-related values:

* Monthly EMI
* Total payment
* Total interest

### 🧾 GST Calculator

Perform GST calculations:

* Add GST
* Remove GST
* Calculate GST amount
* Calculate final amount

### 📊 Percentage Calculator

Perform percentage-related calculations such as:

* Percentage of a value
* Percentage changes
* Other supported percentage operations

### 🏷️ Discount Calculator

Calculate:

* Discount amount
* Final price
* Amount saved

### 🕘 Calculation History

The application stores calculation history in PostgreSQL.

Users can:

* View previous calculations
* Review calculation details
* Delete individual history records
* Clear calculation history

---

# 🛠️ Tech Stack

## Frontend

* HTML5
* CSS3
* JavaScript
* Fetch API

The frontend communicates with the Spring Boot backend through REST APIs.

## Backend

* Java 21
* Spring Boot 3.2.5
* Spring Web
* Spring Data JPA
* Hibernate
* Spring Validation
* Maven
* Lombok

## Database

* PostgreSQL
* Neon PostgreSQL

The application uses PostgreSQL for persistent calculation history.

## API

* REST API
* Swagger / OpenAPI

## Development Tools

* Visual Studio Code
* Git
* GitHub
* Maven
* Postman / Swagger for API testing

## Deployment

* Vercel for frontend
* Render for Spring Boot backend
* Neon for PostgreSQL database

---

# 🏗️ Architecture

```text
                    USER
                      │
                      ▼
             ┌─────────────────┐
             │    Vercel       │
             │    Frontend     │
             │ HTML/CSS/JS     │
             └────────┬────────┘
                      │
                  REST API
                      │
                      ▼
             ┌─────────────────┐
             │     Render      │
             │  Spring Boot    │
             │    Backend      │
             └────────┬────────┘
                      │
                  JPA/Hibernate
                      │
                      ▼
             ┌─────────────────┐
             │      Neon       │
             │   PostgreSQL    │
             └─────────────────┘
```

---

# 📁 Project Structure

```text
Multi-Utility-Calculator/
│
├── backend/
│   │
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── calculator/
│   │   │   │           ├── CalculatorApplication.java
│   │   │   │           ├── controller/
│   │   │   │           ├── service/
│   │   │   │           ├── repository/
│   │   │   │           ├── entity/
│   │   │   │           └── ...
│   │   │   │
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   │
│   │   └── test/
│   │
│   ├── pom.xml
│   └── Dockerfile
│
├── frontend/
│   ├── index.html
│   ├── css/
│   │   ├── style.css
│   │   └── dashboard.css
│   │
│   ├── js/
│   │   └── ...
│   │
│   └── pages/
│       ├── basic.html
│       ├── bmi.html
│       ├── age.html
│       ├── emi.html
│       ├── gst.html
│       ├── percentage.html
│       ├── discount.html
│       └── history.html
│
├── docs/
│
├── README.md
└── .gitignore
```

> The exact Java package/file names can vary depending on the current source tree.

---

# 🔌 API Endpoints

The backend exposes REST endpoints for the calculator operations.

| Endpoint                    | Method | Purpose                        |
| --------------------------- | ------ | ------------------------------ |
| `/api/basic/calculate`      | POST   | Perform basic calculation      |
| `/api/bmi/calculate`        | POST   | Calculate BMI                  |
| `/api/age/calculate`        | POST   | Calculate age                  |
| `/api/emi/calculate`        | POST   | Calculate EMI                  |
| `/api/gst/calculate`        | POST   | Calculate GST                  |
| `/api/percentage/calculate` | POST   | Perform percentage calculation |
| `/api/discount/calculate`   | POST   | Calculate discount             |
| `/api/history`              | GET    | Retrieve calculation history   |
| `/api/history/{id}`         | DELETE | Delete a history record        |
| `/api/history`              | DELETE | Clear calculation history      |

---

# 🗄️ Database

The application uses **PostgreSQL hosted on Neon**.

The calculation history table stores information such as:

```text
calculation_history
├── id
├── calculator_type
├── input_data
├── result_data
└── created_at
```

The Spring Boot application uses:

```text
Spring Data JPA
        ↓
Hibernate
        ↓
PostgreSQL
```

---

# 🔐 Database Configuration

Database credentials are **not stored directly in the source code**.

The application reads database configuration from environment variables:

```properties
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
```

This keeps database credentials outside the GitHub repository.

For deployment, these variables are configured in **Render Environment Variables**.

---

# 💻 Running the Project Locally

## Prerequisites

Install:

* JDK 21
* Maven
* PostgreSQL / Neon PostgreSQL
* Git
* VS Code or another Java IDE

---

## 1. Clone the Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

Move into the project:

```bash
cd Multi-Utility-Calculator
```

---

# 2. Run the Backend

Move into the backend directory:

```bash
cd backend
```

Run:

```bash
mvn spring-boot:run
```

The Spring Boot application runs on:

```text
http://localhost:8080
```

---

# 3. Build the Backend

To create the executable JAR:

```bash
mvn clean package -DskipTests
```

The generated JAR will be available inside:

```text
backend/target/
```

---

# 4. Run the Frontend

The frontend is a static HTML/CSS/JavaScript application.

You can open the frontend using a local development server.

For example:

```bash
cd frontend
python -m http.server 5500
```

Then open:

```text
http://localhost:5500
```

---

# 🧪 API Testing

The Spring Boot backend can be tested using:

* Swagger/OpenAPI
* Postman
* Browser developer tools

Swagger is available when configured by the application at:

```text
http://localhost:8080/swagger-ui.html
```

If your current Swagger configuration exposes a different path, use the path configured by the application.

---

# 🌐 Deployment

The current deployment architecture is:

```text
Frontend
   ↓
Vercel

Backend
   ↓
Render

Database
   ↓
Neon PostgreSQL
```

### Frontend

The frontend is deployed using **Vercel**.

### Backend

The Spring Boot backend is deployed using **Render**.

### Database

PostgreSQL is hosted using **Neon**.

---

# 🔄 Production Request Flow

When a user performs a calculation:

```text
User
  │
  ▼
Vercel Frontend
  │
  │ HTTP REST Request
  ▼
Render Spring Boot API
  │
  ▼
Calculator Service
  │
  ▼
PostgreSQL / Neon
  │
  ▼
Calculation History
  │
  ▼
Response
  │
  ▼
Vercel Frontend
```

---

# 🔒 Security

The application uses environment variables for database credentials.

Sensitive information such as:

* PostgreSQL password
* Database credentials
* Production configuration

should not be committed to GitHub.

Example:

```properties
DATABASE_URL
DATABASE_USERNAME
DATABASE_PASSWORD
```

These values are configured separately in the deployment environment.

---

# 📱 Responsive Design

The frontend is designed to work across:

* Desktop
* Laptop
* Tablet
* Mobile devices

The dashboard provides access to all calculator modules from a single interface.

---

# 🎯 Project Objectives

The main objectives of this mini project were to gain practical experience in:

* Java development
* Spring Boot
* REST API development
* Spring Data JPA
* Hibernate
* PostgreSQL
* Frontend development
* API integration
* Git and GitHub
* Cloud deployment
* Environment variable configuration
* Full-stack application architecture

---

# 📚 What I Learned

Through this project, I gained hands-on experience with:

1. Building REST APIs using Spring Boot
2. Connecting a Java backend with PostgreSQL
3. Using Spring Data JPA and Hibernate
4. Connecting a JavaScript frontend to REST APIs
5. Managing calculation history
6. Testing APIs
7. Using Git and GitHub
8. Deploying a frontend to Vercel
9. Deploying a Spring Boot backend to Render
10. Connecting a deployed backend to Neon PostgreSQL
11. Managing production database credentials using environment variables
12. Troubleshooting frontend-backend communication and CORS issues

---

# 🛠️ Build Status

| Component              | Status |
| ---------------------- | ------ |
| Basic Calculator       | ✅      |
| BMI Calculator         | ✅      |
| Age Calculator         | ✅      |
| EMI Calculator         | ✅      |
| GST Calculator         | ✅      |
| Percentage Calculator  | ✅      |
| Discount Calculator    | ✅      |
| Calculation History    | ✅      |
| Spring Boot Backend    | ✅      |
| PostgreSQL Integration | ✅      |
| REST API               | ✅      |
| GitHub                 | ✅      |
| Vercel Deployment      | ✅      |
| Render Deployment      | ✅      |
| Neon PostgreSQL        | ✅      |

---

# 👩‍💻 Project Type

**Mini Project**

**Domain:** Full Stack Web Development

**Primary Role:** Full Stack Java Developer

---

# 📄 License

This project was developed for educational and learning purposes.

```
```
