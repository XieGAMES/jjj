# Project Context: WAM (Web Application Manager)

## Project Overview
This is a Java Maven project named "wam" (Web Application Manager), with artifact ID `wam` and version `1.0-SNAPSHOT`. The project is configured to use Java 17 as both source and target compatibility level. It follows standard Maven directory structure with source code in `src/main/java` and tests in `src/test/java`.

The project currently contains a simple "Hello World" application in the `org.example` package as the main entry point. The project appears to be in early development stages with minimal functionality implemented.

## Project Structure
```
wam/
├── pom.xml                 # Maven configuration file
├── .gitignore             # Git ignore patterns
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               └── Main.java    # Main application class
│   └── test/
│       └── java/                    # Test directory (currently empty)
└── .idea/                 # IntelliJ IDEA configuration files
```

## Technologies Used
- Java 17
- Apache Maven (build tool)
- Maven wrapper (for consistent builds)

## Building and Running

### Prerequisites
- Java 17 JDK
- Apache Maven 3.x (or use Maven wrapper)

### Build Commands
```bash
# Build the project using Maven wrapper
./mvnw clean compile

# Package the application
./mvnw clean package

# Run the application (executes the main class)
./mvnw exec:java -Dexec.mainClass="zd.zmk.Main"

# Run tests (if any exist)
./mvnw test

# Clean build artifacts
./mvnw clean
```

### Alternative Maven Commands
If Maven is installed system-wide:
```bash
mvn clean compile
mvn clean package
mvn exec:java -Dexec.mainClass="zd.zmk.Main"
mvn test
```

## Project Configuration
The `pom.xml` file defines:
- Group ID: `org.example`
- Artifact ID: `wam`
- Version: `1.0-SNAPSHOT`
- Java source and target level: 17
- Project encoding: UTF-8

## Development Conventions
- Standard Maven project structure is followed
- Java source files are in `src/main/java`
- Test files should go in `src/test/java`
- The project uses UTF-8 encoding
- IntelliJ IDEA project files are configured for development

## Current State
The project currently contains only a basic "Hello World" application with no additional functionality. The test directory is empty, suggesting that testing has not yet been implemented.

## IDE Support
The project includes IntelliJ IDEA configuration files, indicating it's set up for development with IntelliJ IDEA. The project is configured to use Java 17 SDK.