# Web Application Manager (WAM)

## Project Structure
This project consists of:
- Main Spring Boot application (REST API backend)
- Desktop module (JavaFX native desktop application)

## Running the Application

### Prerequisites
- Java 17+
- Maven 3.6+

### Backend API Server
To run the backend server:
```bash
./mvnw spring-boot:run
```
Or:
```bash
java -jar target/wam-1.0-SNAPSHOT.jar
```

### Desktop Application
To run the desktop application:
```bash
cd desktop
../mvnw javafx:run
```

### Building the Project
To build the entire project:
```bash
./mvnw clean package
```

## Project Modules
- `wam` (parent): Contains the main Spring Boot application
- `desktop`: Native JavaFX desktop application that connects to the API

## Technologies Used
- Spring Boot 3.2+
- JavaFX 20+
- PostgreSQL
- Liquibase
- Maven