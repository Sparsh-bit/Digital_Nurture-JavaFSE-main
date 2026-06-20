# JUnit Advanced Testing Exercises

This project contains the solutions for **Assignment 2 — JUnit Advanced Testing Exercises** from the Digital Nurture Java FSE Deepskilling program. It demonstrates advanced JUnit 5 (Jupiter) testing features including parameterized tests, test suites, execution ordering, exception testing, and performance/timeout assertions.

## Project Structure

```
JUnitAdvancedTesting/
├── pom.xml
├── README.md
├── src/
│   ├── main/java/com/digitalnurture/testing/
│   │   ├── EvenChecker.java           (Exercise 1)
│   │   ├── ExceptionThrower.java      (Exercise 4)
│   │   └── PerformanceTester.java     (Exercise 5)
│   └── test/java/com/digitalnurture/testing/
│       ├── EvenCheckerTest.java       (Exercise 1 — Parameterized Tests)
│       ├── AllTests.java              (Exercise 2 — Test Suite)
│       ├── OrderedTests.java          (Exercise 3 — Execution Order)
│       ├── ExceptionThrowerTest.java  (Exercise 4 — Exception Testing)
│       └── PerformanceTesterTest.java (Exercise 5 — Timeout Testing)
```

- **Build Tool:** Maven (`pom.xml`)
- **Testing Framework:** JUnit 5 (Jupiter) 5.10.2
- **Java Version:** 11

---

## Exercise Breakdown

### Exercise 1: Parameterized Tests

**Objective:** Test the `EvenChecker.isEven(int)` method with multiple inputs using a single parameterized test method instead of writing repetitive individual test cases.

**Source Class:** `EvenChecker.java`
- Contains a method `isEven(int number)` that returns `true` if the number is divisible by 2.

**Test Class:** `EvenCheckerTest.java`
- Uses `@ParameterizedTest` to define test methods that accept arguments from a data source.
- Uses `@ValueSource(ints = {...})` to supply a fixed set of integer values as test inputs.
- **`testIsEven_withEvenNumbers`** — Verifies that known even numbers (0, 2, 4, 10, 100, -2, -8, 1024) return `true`.
- **`testIsEven_withOddNumbers`** — Verifies that known odd numbers (1, 3, 5, 11, 99, -1, -7, 1023) return `false`.

**How It Works:**
The `@ParameterizedTest` annotation tells JUnit to run the test method once for each value provided by `@ValueSource`. Each execution is treated as a separate test invocation, making the test output clear and granular.

---

### Exercise 2: Test Suites and Categories

**Objective:** Group multiple related test classes into a single test suite so they can be executed together as a unit.

**Test Suite Class:** `AllTests.java`
- Uses `@Suite` annotation (from `junit-platform-suite-api`) to designate the class as a test suite entry point.
- Uses `@SelectClasses` to explicitly list the test classes included in the suite:
  - `EvenCheckerTest.class`
  - `OrderedTests.class`
  - `ExceptionThrowerTest.class`
  - `PerformanceTesterTest.class`

**How It Works:**
Running the `AllTests` class triggers the execution of all four selected test classes in sequence. This is useful for organizing related tests into logical groups, CI/CD pipeline integration, and generating consolidated test reports.

---

### Exercise 3: Test Execution Order

**Objective:** Control the order in which test methods are executed within a test class.

**Test Class:** `OrderedTests.java`
- Uses `@TestMethodOrder(MethodOrderer.OrderAnnotation.class)` at the class level to enable order-based execution.
- Each test method is annotated with `@Order(n)` where `n` determines the execution sequence.
- Execution order: `testAddition` → `testStringConcatenation` → `testObjectCreation` → `testBooleanLogic` → `testArrayLength`.

**How It Works:**
By default, JUnit 5 does not guarantee the execution order of test methods. The `@TestMethodOrder` annotation overrides this behavior. The `MethodOrderer.OrderAnnotation` strategy sorts methods by their `@Order` value in ascending order.

> **Note:** While ordered tests are demonstrated here, best practice recommends that unit tests remain independent and not rely on execution order.

---

### Exercise 4: Exception Testing

**Objective:** Verify that methods throw the expected exceptions under specific error conditions.

**Source Class:** `ExceptionThrower.java`
- `throwException()` — Always throws an `IllegalArgumentException` with the message "Invalid argument provided".
- `validateInput(String input)` — Throws `NullPointerException` if input is `null`, or `IllegalArgumentException` if input is empty.

**Test Class:** `ExceptionThrowerTest.java`
- Uses `assertThrows(ExpectedExceptionType.class, executable)` to verify that the correct exception type is thrown.
- **`testThrowException_throwsIllegalArgumentException`** — Asserts that `throwException()` raises an `IllegalArgumentException`.
- **`testThrowException_hasCorrectMessage`** — Captures the thrown exception and verifies its message content.
- **`testValidateInput_withNull_throwsNullPointerException`** — Asserts that passing `null` raises a `NullPointerException`.
- **`testValidateInput_withEmptyString_throwsIllegalArgumentException`** — Asserts that passing an empty string raises an `IllegalArgumentException`.

**How It Works:**
`assertThrows` accepts the expected exception class and a lambda (executable). If the lambda throws the expected exception, the assertion passes and returns the exception object for further inspection (e.g., message verification). If no exception or a different exception is thrown, the test fails.

---

### Exercise 5: Timeout and Performance Testing

**Objective:** Ensure that methods complete execution within a specified time limit, simulating SLA-style performance constraints.

**Source Class:** `PerformanceTester.java`
- `performTask()` — Simulates a time-consuming operation using `Thread.sleep(500)`.
- `quickTask()` — Performs a fast arithmetic computation (sum of 1 to 1000).

**Test Class:** `PerformanceTesterTest.java`
- **`testPerformTask_completesWithinTimeout`** — Uses `assertTimeout(Duration.ofSeconds(2), ...)` to verify that `performTask()` finishes within 2 seconds.
- **`testPerformTask_completesWithinPreemptiveTimeout`** — Uses `assertTimeoutPreemptively(Duration.ofSeconds(1), ...)` which aborts the execution immediately if the timeout is exceeded.
- **`testQuickTask_completesRapidly`** — Verifies that `quickTask()` completes within 100 milliseconds and produces the correct result.
- **`testPerformTask_doesNotThrowException`** — Uses `assertDoesNotThrow` to confirm no unexpected exceptions occur.

**How It Works:**
- `assertTimeout` waits for the executable to finish, then checks the elapsed time. The test fails if the duration exceeded the limit, but the method runs to completion regardless.
- `assertTimeoutPreemptively` runs the executable in a separate thread and aborts it immediately if the timeout is exceeded. This is more aggressive and prevents long-running operations from blocking the test suite.

---

## Dependencies

| Dependency | Version | Purpose |
|---|---|---|
| `junit-jupiter-api` | 5.10.2 | Core JUnit 5 API for writing tests |
| `junit-jupiter-engine` | 5.10.2 | Test engine for running JUnit 5 tests |
| `junit-jupiter-params` | 5.10.2 | Support for parameterized tests |
| `junit-platform-suite-api` | 1.10.2 | API for defining test suites |
| `junit-platform-suite-engine` | 1.10.2 | Engine for running test suites |
| `maven-surefire-plugin` | 3.2.5 | Maven plugin for test execution |

---

## Getting Started

### Prerequisites
- Java 11 or later
- Apache Maven 3.6+

### Build and Run Tests

1. **Navigate to the project directory:**
   ```bash
   cd JUnitAdvancedTesting
   ```

2. **Compile the project:**
   ```bash
   mvn compile
   ```

3. **Run all tests:**
   ```bash
   mvn test
   ```

4. **Run a specific test class:**
   ```bash
   mvn test -Dtest=EvenCheckerTest
   mvn test -Dtest=OrderedTests
   mvn test -Dtest=ExceptionThrowerTest
   mvn test -Dtest=PerformanceTesterTest
   mvn test -Dtest=AllTests
   ```

### Running in an IDE
1. Open the project in IntelliJ IDEA or Eclipse.
2. The IDE will automatically resolve Maven dependencies.
3. Right-click on any test class or the `AllTests` suite and select **Run** to execute the tests.

---

## Key JUnit 5 Annotations Used

| Annotation | Description |
|---|---|
| `@ParameterizedTest` | Marks a method as a parameterized test that runs with multiple inputs |
| `@ValueSource` | Supplies literal values (ints, strings, etc.) as arguments to parameterized tests |
| `@Suite` | Designates a class as a test suite entry point |
| `@SelectClasses` | Specifies test classes to include in a test suite |
| `@TestMethodOrder` | Configures the ordering strategy for test methods in a class |
| `@Order` | Assigns execution priority to a test method |
| `@Test` | Marks a method as a standard test method |
| `@BeforeEach` | Specifies setup logic to run before each test method |
| `@DisplayName` | Provides a human-readable name for a test method in reports |

---

## Purpose

This project demonstrates how to:
1. Write parameterized tests to avoid repetitive test code.
2. Organize tests into suites for grouped execution.
3. Control test execution order when sequence matters.
4. Test exception-throwing behavior and validate error messages.
5. Enforce performance constraints using timeout assertions.
