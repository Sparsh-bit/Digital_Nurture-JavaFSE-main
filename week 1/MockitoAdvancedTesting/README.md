# Advanced Mockito Hands-On Exercises

This project contains clean, professional, and well-documented implementations and JUnit 5 test cases for the **Advanced Mockito Hands-On Exercises** as part of the Digital Nurture program.

---

## 📂 Project Directory Structure

```text
MockitoAdvancedTesting/
├── pom.xml
├── README.md
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── digitalnurture
    │               └── advancedtesting
    │                   ├── ApiService.java
    │                   ├── FileReader.java
    │                   ├── FileService.java
    │                   ├── FileWriter.java
    │                   ├── NetworkClient.java
    │                   ├── NetworkService.java
    │                   ├── Repository.java
    │                   ├── RestClient.java
    │                   └── Service.java
    └── test
        └── java
            └── com
                └── digitalnurture
                    └── advancedtesting
                        ├── Exercise1_MockRepositoryTest.java
                        ├── Exercise2_MockRestClientTest.java
                        ├── Exercise3_MockFileIOTest.java
                        ├── Exercise4_MockNetworkClientTest.java
                        └── Exercise5_MultipleReturnsTest.java
```

---

## 🛠️ Technology Stack & Dependencies

The project is built on Maven and integrates the following test framework versions:
*   **Java Version**: 11 or higher
*   **JUnit Jupiter (JUnit 5)**: `5.10.2`
*   **Mockito Core**: `5.11.0`
*   **Mockito JUnit Jupiter Integration**: `5.11.0`

Dependencies are configured in [pom.xml](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/pom.xml).

---

## 📝 Exercise Implementations & Explanation

### Exercise 1: Mocking Databases and Repositories

**Objective**: Test a service that interacts with a database repository.
*   **Mock Target**: [Repository.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/main/java/com/digitalnurture/advancedtesting/Repository.java)
*   **Service Under Test**: [Service.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/main/java/com/digitalnurture/advancedtesting/Service.java)
*   **Test Case**: [Exercise1_MockRepositoryTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/test/java/com/digitalnurture/advancedtesting/Exercise1_MockRepositoryTest.java)

**How it works**:
1. We mock the `Repository` interface using Mockito's `mock(Repository.class)`.
2. We stub the `getData()` method to return `"Mock Data"`.
3. We instantiate `Service` by passing the mock dependency via constructor injection.
4. We verify that `processData()` successfully formats and processes the mocked data.

---

### Exercise 2: Mocking External Services (RESTful APIs)

**Objective**: Test a service that calls an external RESTful API.
*   **Mock Target**: [RestClient.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/main/java/com/digitalnurture/advancedtesting/RestClient.java)
*   **Service Under Test**: [ApiService.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/main/java/com/digitalnurture/advancedtesting/ApiService.java)
*   **Test Case**: [Exercise2_MockRestClientTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/test/java/com/digitalnurture/advancedtesting/Exercise2_MockRestClientTest.java)

**How it works**:
1. We mock the HTTP client wrapper `RestClient` interface using `mock(RestClient.class)`.
2. We stub `getResponse()` to simulate API results by returning `"Mock Response"`.
3. The `ApiService` fetches raw response messages using `restClient.getResponse()` and prepends the protocol prefix `"Fetched "`.

---

### Exercise 3: Mocking File I/O

**Objective**: Test a service that reads from and writes to files.
*   **Mock Targets**: [FileReader.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/main/java/com/digitalnurture/advancedtesting/FileReader.java) and [FileWriter.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/main/java/com/digitalnurture/advancedtesting/FileWriter.java)
*   **Service Under Test**: [FileService.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/main/java/com/digitalnurture/advancedtesting/FileService.java)
*   **Test Case**: [Exercise3_MockFileIOTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/test/java/com/digitalnurture/advancedtesting/Exercise3_MockFileIOTest.java)

**How it works**:
1. We mock physical file system entities `FileReader` and `FileWriter`.
2. We stub the reader to return `"Mock File Content"` when `.read()` is called.
3. We stub the writer's void method using `doNothing().when(mockFileWriter).write(anyString())`.
4. We verify that `FileService.processFile()` reads the content, processes it, writes it to `FileWriter`, and returns the expected `"Processed Mock File Content"`.

---

### Exercise 4: Mocking Network Interactions

**Objective**: Test a service that interacts with network resources.
*   **Mock Target**: [NetworkClient.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/main/java/com/digitalnurture/advancedtesting/NetworkClient.java)
*   **Service Under Test**: [NetworkService.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/main/java/com/digitalnurture/advancedtesting/NetworkService.java)
*   **Test Case**: [Exercise4_MockNetworkClientTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/test/java/com/digitalnurture/advancedtesting/Exercise4_MockNetworkClientTest.java)

**How it works**:
1. We create a mock `NetworkClient` dependency representing connection-oriented resources.
2. We stub `.connect()` to return `"Mock Connection"`.
3. We test `NetworkService.connectToServer()` and ensure it correctly constructs the network details response.

---

### Exercise 5: Mocking Multiple Return Values

**Objective**: Test a service that calls a method multiple times with different return values.
*   **Mock Target**: [Repository.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/main/java/com/digitalnurture/advancedtesting/Repository.java)
*   **Service Under Test**: [Service.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/main/java/com/digitalnurture/advancedtesting/Service.java)
*   **Test Case**: [Exercise5_MultipleReturnsTest.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/MockitoAdvancedTesting/src/test/java/com/digitalnurture/advancedtesting/Exercise5_MultipleReturnsTest.java)

**How it works**:
1. We stub the database method `getData()` with consecutive returns: `when(mockRepository.getData()).thenReturn("First Mock Data").thenReturn("Second Mock Data");`
2. We invoke `processData()` twice on `Service`.
3. We assert that the first call processes `"First Mock Data"` and the second call processes `"Second Mock Data"`.

---

## ⚡ How to Build & Run Tests

Use Apache Maven to compile the sources and execute the complete suite of tests:

```bash
# Navigate to the project folder
cd "Java FSE/Deepskilling/JUnit, Mockito and SL4J/MockitoAdvancedTesting"

# Clean build and run the Mockito test suite
mvn clean test
```

Expected output:
```text
[INFO] Scanning for projects...
[INFO] ----------------< com.digitalnurture.testing:MockitoAdvancedTesting >----------------
[INFO] Building Advanced Mockito Hands-On Exercises 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
...
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.digitalnurture.advancedtesting.Exercise1_MockRepositoryTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.123 s -- in com.digitalnurture.advancedtesting.Exercise1_MockRepositoryTest
[INFO] Running com.digitalnurture.advancedtesting.Exercise2_MockRestClientTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.005 s -- in com.digitalnurture.advancedtesting.Exercise2_MockRestClientTest
[INFO] Running com.digitalnurture.advancedtesting.Exercise3_MockFileIOTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.004 s -- in com.digitalnurture.advancedtesting.Exercise3_MockFileIOTest
[INFO] Running com.digitalnurture.advancedtesting.Exercise4_MockNetworkClientTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.003 s -- in com.digitalnurture.advancedtesting.Exercise4_MockNetworkClientTest
[INFO] Running com.digitalnurture.advancedtesting.Exercise5_MultipleReturnsTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.004 s -- in com.digitalnurture.advancedtesting.Exercise5_MultipleReturnsTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
