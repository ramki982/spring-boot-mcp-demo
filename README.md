# Spring Boot MCP Demo

This is a demo project for a Spring Boot application implementing the Model Context Protocol (MCP).

## Project Structure

- **src/main/java**: Contains the main Java source code for the application.
  - `com.example.spring_boot_mcp_demo`: Includes the main application classes such as `Book`, `BookController`, `DemoApplication`, and `DemoController`.
- **src/main/resources**: Contains application resources such as `application.properties`, `books.json`, and templates.
- **src/test/java**: Contains test cases for the application.
- **build/**: Contains compiled classes, generated sources, and build reports.
- **gradle/**: Gradle wrapper files.

## Prerequisites

- Java 17 or higher
- Gradle 7.6 or higher

## How to Run

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd spring-boot-mcp-demo
   ```
3. Build the project:
   ```bash
   ./gradlew build
   ```
4. Run the application:
   ```bash
   ./gradlew bootRun
   ```

## Endpoints

- **GET /books**: Fetches a list of books.
- **POST /books**: Adds a new book.

## License

This project is licensed under the MIT License.