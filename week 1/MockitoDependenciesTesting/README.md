# Mocking Dependencies in Spring Tests using Mockito

This project contains clean, professional, and well-documented implementations and JUnit 5 test cases for the **Mocking Dependencies in Spring Tests** exercises as part of the Digital Nurture program.

---

## 📂 Project Directory Structure

```text
MockitoDependenciesTesting/
├── pom.xml
├── README.md
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── digitalnurture
    │               └── dependenciestesting
    │                   ├── Application.java
    │                   ├── User.java
    │                   ├── UserController.java
    │                   ├── UserRepository.java
    │                   └── UserService.java
    └── test
        └── java
            └── com
                └── digitalnurture
                    └── dependenciestesting
                        ├── Exercise1_UserControllerTest.java
                        ├── Exercise2_UserServiceTest.java
                        └── Exercise3_UserIntegrationTest.java
```

---

## 🛠️ Technology Stack & Dependencies

The project is built on Maven and integrates the following test framework versions:
*   **Java Version**: 17
*   **Spring Boot Version**: `3.2.5`
*   **Spring Boot Starter Web**: Handles REST endpoints.
*   **Spring Boot Starter Data JPA**: Handles entity mapping and repositories.
*   **Spring Boot Starter Test**: Bundles JUnit Jupiter, Mockito, MockMvc, AssertJ, and JSONAssert.
*   **H2 Database**: Provides an in-memory SQL database for integration tests.

Dependencies are configured in [pom.xml](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoDependenciesTesting/pom.xml).

---

## 📝 Exercise Implementations & Explanation

### Exercise 1: Mocking a Service Dependency in a Controller Test
*   **Controller**: [UserController.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoDependenciesTesting/src/main/java/com/digitalnurture/dependenciestesting/UserController.java)
*   **Test**: [Exercise1_UserControllerTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoDependenciesTesting/src/test/java/com/digitalnurture/dependenciestesting/Exercise1_UserControllerTest.java)
*   **Concept**: Unit test for the Spring controller using `@WebMvcTest(UserController.class)`. We mock the `UserService` dependency using `@MockBean` so that the web slice runs in isolation, verifying correct JSON payloads via `MockMvc`.

### Exercise 2: Mocking a Repository in a Service Test
*   **Service**: [UserService.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoDependenciesTesting/src/main/java/com/digitalnurture/dependenciestesting/UserService.java)
*   **Test**: [Exercise2_UserServiceTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoDependenciesTesting/src/test/java/com/digitalnurture/dependenciestesting/Exercise2_UserServiceTest.java)
*   **Concept**: Pure unit test for the Spring service using `@ExtendWith(MockitoExtension.class)`. We mock `UserRepository` using `@Mock` and inject it into the service using `@InjectMocks` to test business logic in isolation without starting a Spring Context.

### Exercise 3: Mocking a Service Dependency in an Integration Test
*   **Test**: [Exercise3_UserIntegrationTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoDependenciesTesting/src/test/java/com/digitalnurture/dependenciestesting/Exercise3_UserIntegrationTest.java)
*   **Concept**: Integration test using `@SpringBootTest` and `@AutoConfigureMockMvc`. We mock the `UserService` bean with `@MockBean` to observe and verify controller and framework configurations end-to-end.

---

## ⚡ How to Build & Run Tests

Use Apache Maven to compile the sources and execute the complete suite of tests:

```bash
# Navigate to the project folder
cd "Java FSE/Deepskilling/JUnit, Mockito and SL4J/MockitoDependenciesTesting"

# Clean build and run the test suite
mvn clean test
```

Expected output:
```text
[INFO] Scanning for projects...
[INFO] ----------------< com.digitalnurture.dependenciestesting:MockitoDependenciesTesting >----------------
[INFO] Building Spring Mock Dependencies Testing 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
...
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.digitalnurture.dependenciestesting.Exercise1_UserControllerTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.digitalnurture.dependenciestesting.Exercise2_UserServiceTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.digitalnurture.dependenciestesting.Exercise3_UserIntegrationTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
