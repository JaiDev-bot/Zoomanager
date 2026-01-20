# Zoomanager 🐘📝

A web API system designed to facilitate **zoo management routines**, covering the administration of animals, caretakers (tratadores), and essential daily tasks.



The project is structured as a Spring Boot application:

* **Application/Domain Layer (REST API)**: Developed in Java and Spring Boot, this API handles the logic for managing entities and the task lifecycle.
* **Data Layer**: Uses **Spring Data JPA** for persistence with a **PostgreSQL** database.

---

## Features

### Domain Management API

Zoomanager exposes RESTful endpoints for the control of all main entities.

* **Animal Management (`/animal`)**: Endpoints to **add** (`POST`) and **list** (`GET`) animals.
* **Caretaker Management (`/cuidador`)**: Endpoints to **add** (`POST`) and **list** (`GET`) caretakers (Tratador).
* **Task Management (`/tarefa`)**:
    * **Task Creation**: `POST /tarefa` creates a new task (e.g., **ALIMENTACAO** / *Feeding*) initialized with the **ABERTA** (*Open*) status.
    * **Execution Start**: `PATCH /tarefa/iniciar/{tarefaId}` moves the task status to **EXECUTANDO** (*Executing*).
* **Interactive Documentation**: The API has integrated **Swagger UI** documentation.

---

## Requirements

### Zoomanager API

* **Java JDK 21+**
* **Apache Maven** (Wrapper included)
* **PostgreSQL** instance

---

## How to Run

### Database Configuration

The application requires PostgreSQL connection details, primarily configured via environment variables in `src/main/resources/application.properties`.

| Environment Variable | Description |
| :--- | :--- |
| `DB_HOST` | PostgreSQL host. |
| `DB_PORT` | PostgreSQL port. |
| `DB_NAME` | Database name. |
| `DB_USERNAME` | Access user. |
| `DB_PASSWORD` | Access password. |

For local development, the `local` profile (active by default) sets default values for the connection (except password) in `application-local.properties`.

### Running the Application

Prerequisites: Ensure Java 21+ is installed and PostgreSQL is running.

1.  **Navigate to the project root directory**:
    ```bash
    cd <path_to_Zoomanager>
    ```
2.  **Start the application using the Maven Wrapper**:
    ```bash
    # On Linux/macOS
    ./mvnw spring-boot:run

    # On Windows (cmd.exe or PowerShell)
    .\mvnw.cmd spring-boot:run
    ```

**Access:** The API will run on `http://localhost:8080`.
**Documentation:** Swagger UI is available at `http://localhost:8080/swagger-ui.html`.

---

## Tests

The project includes unit tests using JUnit 5 and Mockito.

To execute all tests:

```bash
./mvnw test
```

### Continuous Integration

A **GitHub Action** workflow (`.github/workflows/test-check.yml`) is configured to run the Maven build and the test suite on every Pull Request targeting the `main` branch.

---

## License

This project is released under the **MIT** license.

---

## Key Dependencies

* **Spring Boot Starter Web**
* **Spring Boot Starter Data JPA**
* **PostgreSQL Driver** (`org.postgresql`)
* **Springdoc OpenAPI**
* **Mockito/JUnit** (for testing)
