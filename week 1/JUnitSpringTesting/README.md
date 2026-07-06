# Spring Testing Exercises

This project contains clean, professional, and well-documented implementations and JUnit 5 test cases for the **Spring Boot Testing Exercises** as part of the Digital Nurture program.

---

## 📂 Project Directory Structure

```text
JUnitSpringTesting/
├── pom.xml
├── README.md
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── digitalnurture
    │               └── springtesting
    │                   ├── Application.java
    │                   ├── CalculatorService.java
    │                   ├── GlobalExceptionHandler.java
    │                   ├── User.java
    │                   ├── UserController.java
    │                   └── UserRepository.java
    │                   └── UserService.java
    └── test
        └── java
            └── com
                └── digitalnurture
                    └── springtesting
                        ├── Exercise1_CalculatorServiceTest.java
                        ├── Exercise2_UserServiceUnitTest.java
                        ├── Exercise3_UserControllerGetTest.java
                        ├── Exercise4_UserIntegrationTest.java
                        ├── Exercise5_UserControllerPostTest.java
                        ├── Exercise6_UserServiceExceptionTest.java
                        ├── Exercise7_UserRepositoryJpaTest.java
                        ├── Exercise8_ControllerExceptionHandlingTest.java
                        └── Exercise9_ParameterizedCalculatorTest.java
```

---

## 🛠️ Technology Stack & Dependencies

The project is built on Maven and integrates the following test framework versions:
*   **Java Version**: 17
*   **Spring Boot Version**: `3.2.5`
*   **Spring Boot Starter Web**: Handles REST endpoints.
*   **Spring Boot Starter Data JPA**: Handles entity mapping and repositories.
*   **Spring Boot Starter Test**: Bundles JUnit Jupiter, Mockito, MockMvc, AssertJ, and JSONAssert.
*   **H2 Database**: Provides an in-memory SQL database for slice/integration tests.

Dependencies are configured in [pom.xml](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/pom.xml).

---

## 📝 Exercise Implementations & Explanation

### Exercise 1: Basic Unit Test for a Service Method
*   **Service**: [CalculatorService.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/main/java/com/digitalnurture/springtesting/CalculatorService.java)
*   **Test**: [Exercise1_CalculatorServiceTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/test/java/com/digitalnurture/springtesting/Exercise1_CalculatorServiceTest.java)
*   **Concept**: Standard JUnit 5 unit testing without boot contexts. Uses basic assertions to verify `add()` correctness.

### Exercise 2: Mocking a Repository in a Service Test
*   **Service**: [UserService.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/main/java/com/digitalnurture/springtesting/UserService.java)
*   **Repository**: [UserRepository.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/main/java/com/digitalnurture/springtesting/UserRepository.java)
*   **Test**: [Exercise2_UserServiceUnitTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/test/java/com/digitalnurture/springtesting/Exercise2_UserServiceUnitTest.java)
*   **Concept**: Uses `@ExtendWith(MockitoExtension.class)` to run unit tests. We mock `UserRepository` to avoid booting Spring contexts, verifying that `UserService.getUserById()` returns expected users.

### Exercise 3: Testing a REST Controller with MockMvc
*   **Controller**: [UserController.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/main/java/com/digitalnurture/springtesting/UserController.java)
*   **Test**: [Exercise3_UserControllerGetTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/test/java/com/digitalnurture/springtesting/Exercise3_UserControllerGetTest.java)
*   **Concept**: Uses `@WebMvcTest(UserController.class)` to load only the web layer. We `@MockBean` the `UserService` and perform requests via `MockMvc` to verify HTTP status codes, Content-Type, and response bodies in JSON format.

### Exercise 4: Integration Test with Spring Boot
*   **Test**: [Exercise4_UserIntegrationTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/test/java/com/digitalnurture/springtesting/Exercise4_UserIntegrationTest.java)
*   **Concept**: Full integration test using `@SpringBootTest` with `@AutoConfigureMockMvc`. Tests the full flow end-to-end (Controller -> Service -> Repository -> database) using an auto-configured in-memory H2 database.

### Exercise 5: Test Controller POST Endpoint
*   **Controller**: [UserController.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/main/java/com/digitalnurture/springtesting/UserController.java)
*   **Test**: [Exercise5_UserControllerPostTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/test/java/com/digitalnurture/springtesting/Exercise5_UserControllerPostTest.java)
*   **Concept**: Slice test using `MockMvc` and `@WebMvcTest(UserController.class)`. Utilizes Jackson `ObjectMapper` to serialize a user object into JSON, performs a POST request, and asserts that the controller responds with HTTP 200 and the correct body.

### Exercise 6: Test Service Exception Handling
*   **Service**: [UserService.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/main/java/com/digitalnurture/springtesting/UserService.java)
*   **Test**: [Exercise6_UserServiceExceptionTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/test/java/com/digitalnurture/springtesting/Exercise6_UserServiceExceptionTest.java)
*   **Concept**: Service-level unit test verifying exception propagation. Asserts that requesting a non-existent user throws a `NoSuchElementException`.

### Exercise 7: Test Custom Repository Query
*   **Repository**: [UserRepository.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/main/java/com/digitalnurture/springtesting/UserRepository.java)
*   **Test**: [Exercise7_UserRepositoryJpaTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/test/java/com/digitalnurture/springtesting/Exercise7_UserRepositoryJpaTest.java)
*   **Concept**: Data tier slice test using `@DataJpaTest`. Boots only JpaRepository interfaces and entities in-memory to test the custom query method `findByName()`.

### Exercise 8: Test Controller Exception Handling
*   **Exception Handler**: [GlobalExceptionHandler.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/main/java/com/digitalnurture/springtesting/GlobalExceptionHandler.java)
*   **Test**: [Exercise8_ControllerExceptionHandlingTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/test/java/com/digitalnurture/springtesting/Exercise8_ControllerExceptionHandlingTest.java)
*   **Concept**: Asserts that exceptions thrown within controller methods are caught by `@ControllerAdvice` and correctly translated to client-facing REST responses (such as HTTP 404 with error body "User not found").

### Exercise 9: Parameterized Test with JUnit
*   **Test**: [Exercise9_ParameterizedCalculatorTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/JUnitSpringTesting/src/test/java/com/digitalnurture/springtesting/Exercise9_ParameterizedCalculatorTest.java)
*   **Concept**: Uses `@ParameterizedTest` and `@CsvSource` to clean up boilerplate tests. Feeds a sequence of variables (inputs and expected output sums) to verify a calculator's addition methods under various conditions.

---

## ⚡ How to Build & Run Tests

Use Apache Maven to compile the sources and execute the complete suite of tests:

```bash
# Navigate to the project folder
cd "Java FSE/Deepskilling/JUnit, Mockito and SL4J/JUnitSpringTesting"

# Clean build and run the test suite
mvn clean test
```

Expected output:
```text
[INFO] Scanning for projects...
[INFO] ----------------< com.digitalnurture.springtesting:JUnitSpringTesting >----------------
[INFO] Building Spring Testing Exercises 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
...
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.digitalnurture.springtesting.Exercise1_CalculatorServiceTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.digitalnurture.springtesting.Exercise2_UserServiceUnitTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.digitalnurture.springtesting.Exercise3_UserControllerGetTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.digitalnurture.springtesting.Exercise4_UserIntegrationTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.digitalnurture.springtesting.Exercise5_UserControllerPostTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.digitalnurture.springtesting.Exercise6_UserServiceExceptionTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.digitalnurture.springtesting.Exercise7_UserRepositoryJpaTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.digitalnurture.springtesting.Exercise8_ControllerExceptionHandlingTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.digitalnurture.springtesting.Exercise9_ParameterizedCalculatorTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 13, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
