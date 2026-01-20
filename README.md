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
1. Ensure the backend server is running
2. Use the run-desktop.bat script:
   ```bash
   run-desktop.bat
   ```

   Or compile and run manually:
   ```bash
   javac -cp "target/classes;." src/main/java/zd/zmk/desktop/DesktopApplication.java
   java -cp "target/classes;." zd.zmk.desktop.DesktopApplication
   ```

### Building the Project
To build the entire project:
```bash
./mvnw clean package
```

## Project Modules
- `wam` (parent): Contains the main Spring Boot application
- `zd.zmk.desktop`: Native JavaFX desktop application that connects to the API

## Technologies Used
- Spring Boot 3.2+
- JavaFX 20+
- PostgreSQL
- Liquibase
- Maven

## Features
- REST API for managing vending machines, products, and sales
- Desktop application for administrators to manage the system
- Data persistence with PostgreSQL
- Automatic database schema management with Liquibase