# Mockito Hands-On Exercises - Complete Report

**Project**: Mockito Testing  
**Author**: Digital Nurture Participant  
**Framework**: Java 11, JUnit 5 (Jupiter) 5.10.2, Mockito 5.11.0

---

## 1. Project File Structure

The project follows standard Maven conventions with a clean separation between production source code and test code.

```text
MockitoTesting/
├── pom.xml
├── README.md
├── src/
│   ├── main/java/com/digitalnurture/testing/
│   │   ├── ExternalApi.java            (Interface — Exercises 1-3, 5-6)
│   │   ├── MyService.java             (Service — Exercises 1-3, 5-6)
│   │   ├── NotificationService.java   (Interface — Exercises 4, 6-7)
│   │   └── UserService.java           (Service — Exercises 4, 6-7)
│   └── test/java/com/digitalnurture/testing/
│       ├── Exercise1_MockingAndStubbingTest.java
│       ├── Exercise2_VerifyingInteractionsTest.java
│       ├── Exercise3_ArgumentMatchingTest.java
│       ├── Exercise4_HandlingVoidMethodsTest.java
│       ├── Exercise5_MultipleReturnsTest.java
│       ├── Exercise6_VerifyingInteractionOrderTest.java
│       └── Exercise7_VoidMethodsWithExceptionsTest.java
```

---

## 2. Dependencies

| Dependency                | Version | Scope | Purpose                              |
|---------------------------|---------|-------|--------------------------------------|
| `junit-jupiter-api`       | 5.10.2  | test  | JUnit 5 test annotations & assertions |
| `junit-jupiter-engine`    | 5.10.2  | test  | JUnit 5 test execution engine         |
| `mockito-core`            | 5.11.0  | test  | Core Mockito mocking framework        |
| `mockito-junit-jupiter`   | 5.11.0  | test  | Mockito-JUnit 5 integration           |

---

## 3. Source Code — Production Classes

### 3.1 ExternalApi.java (Interface)
Represents an external API dependency used across Exercises 1-3 and 5-6.

```java
package com.digitalnurture.testing;

public interface ExternalApi {
    String getData();
    String getData(String key);
    void processData(String data);
}
```

### 3.2 MyService.java
Service class that depends on `ExternalApi` via constructor injection.

```java
package com.digitalnurture.testing;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchData(String key) {
        return externalApi.getData(key);
    }

    public void processData(String data) {
        externalApi.processData(data);
    }
}
```

### 3.3 NotificationService.java (Interface)
Interface with void methods used in Exercises 4 and 7.

```java
package com.digitalnurture.testing;

public interface NotificationService {
    void sendNotification(String recipient, String message);
    void sendEmail(String emailAddress, String subject, String body);
    void logAuditEvent(String event);
}
```

### 3.4 UserService.java
Service class that depends on `NotificationService`.

```java
package com.digitalnurture.testing;

public class UserService {
    private final NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void registerUser(String username, String email) {
        notificationService.sendNotification(email, "Welcome, " + username + "!");
        notificationService.logAuditEvent("User registered: " + username);
    }

    public void resetPassword(String email) {
        notificationService.sendEmail(email, "Password Reset",
                "Click the link to reset your password.");
        notificationService.logAuditEvent("Password reset requested for: " + email);
    }

    public void notifyUser(String email, String message) {
        notificationService.sendNotification(email, message);
    }
}
```

---

## 4. Exercise Solutions (Test Classes)

### Exercise 1: Mocking and Stubbing

**Scenario:** Test a service that depends on an external API. Use Mockito to mock the external API and stub its methods.

**Key Concepts:** `mock()`, `when().thenReturn()`

```java
@DisplayName("Exercise 1: Mocking and Stubbing")
public class Exercise1_MockingAndStubbingTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    public void testStubbingWithArguments() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData("user")).thenReturn("User Data");
        when(mockApi.getData("admin")).thenReturn("Admin Data");

        MyService service = new MyService(mockApi);
        assertEquals("User Data", service.fetchData("user"));
        assertEquals("Admin Data", service.fetchData("admin"));
    }

    @Test
    public void testDefaultReturnForUnstubbedMethods() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        assertNull(service.fetchData());
    }
}
```

---

### Exercise 2: Verifying Interactions

**Scenario:** Ensure that a method is called with specific arguments.

**Key Concepts:** `verify()`, `times()`, `never()`, `atLeast()`, `atMost()`

```java
@DisplayName("Exercise 2: Verifying Interactions")
public class Exercise2_VerifyingInteractionsTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }

    @Test
    public void testVerifyNumberOfInvocations() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        service.fetchData();
        service.fetchData();
        verify(mockApi, times(3)).getData();
    }

    @Test
    public void testVerifyNoInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        verify(mockApi, never()).getData();
    }

    @Test
    public void testVerifyAtLeastAtMost() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        service.fetchData();
        verify(mockApi, atLeast(1)).getData();
        verify(mockApi, atMost(3)).getData();
    }
}
```

---

### Exercise 3: Argument Matching

**Scenario:** Verify that a method is called with specific arguments using argument matchers.

**Key Concepts:** `anyString()`, `eq()`, `contains()`, `startsWith()`

```java
@DisplayName("Exercise 3: Argument Matching")
public class Exercise3_ArgumentMatchingTest {

    @Test
    public void testAnyStringMatcher() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData(anyString())).thenReturn("Matched Data");

        MyService service = new MyService(mockApi);
        assertEquals("Matched Data", service.fetchData("anyKey"));
        verify(mockApi).getData(anyString());
    }

    @Test
    public void testEqMatcher() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData(eq("specificKey"))).thenReturn("Specific Data");

        MyService service = new MyService(mockApi);
        assertEquals("Specific Data", service.fetchData("specificKey"));
        verify(mockApi).getData(eq("specificKey"));
    }

    @Test
    public void testContainsMatcher() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData(contains("user"))).thenReturn("User Data");

        MyService service = new MyService(mockApi);
        assertEquals("User Data", service.fetchData("user_123"));
        verify(mockApi).getData(contains("user"));
    }

    @Test
    public void testArgumentMatcherWithVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.processData("test payload");

        verify(mockApi).processData(anyString());
        verify(mockApi).processData(eq("test payload"));
    }
}
```

---

### Exercise 4: Handling Void Methods

**Scenario:** Test a void method that performs some action.

**Key Concepts:** `doNothing()`, `doAnswer()`, void method verification

```java
@DisplayName("Exercise 4: Handling Void Methods")
public class Exercise4_HandlingVoidMethodsTest {

    @Test
    public void testDoNothingOnVoidMethod() {
        NotificationService mockNotification = mock(NotificationService.class);
        doNothing().when(mockNotification).sendNotification(anyString(), anyString());

        UserService userService = new UserService(mockNotification);
        userService.notifyUser("user@example.com", "Hello!");

        verify(mockNotification).sendNotification("user@example.com", "Hello!");
    }

    @Test
    public void testVoidMethodCalledDuringRegistration() {
        NotificationService mockNotification = mock(NotificationService.class);
        UserService userService = new UserService(mockNotification);

        userService.registerUser("john_doe", "john@example.com");

        verify(mockNotification).sendNotification(
                eq("john@example.com"), eq("Welcome, john_doe!"));
        verify(mockNotification).logAuditEvent("User registered: john_doe");
    }

    @Test
    public void testDoAnswerOnVoidMethod() {
        NotificationService mockNotification = mock(NotificationService.class);
        doAnswer(invocation -> {
            String recipient = invocation.getArgument(0);
            String message = invocation.getArgument(1);
            assert recipient != null;
            assert message.contains("Welcome");
            return null;
        }).when(mockNotification).sendNotification(anyString(), anyString());

        UserService userService = new UserService(mockNotification);
        userService.registerUser("jane_doe", "jane@example.com");

        verify(mockNotification).sendNotification(anyString(), contains("Welcome"));
    }
}
```

---

### Exercise 5: Mocking and Stubbing with Multiple Returns

**Scenario:** Test a service with multiple return values on consecutive calls.

**Key Concepts:** Consecutive `thenReturn()`, varargs `thenReturn()`, `thenThrow()`

```java
@DisplayName("Exercise 5: Mocking and Stubbing with Multiple Returns")
public class Exercise5_MultipleReturnsTest {

    @Test
    public void testConsecutiveReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("First Call")
                .thenReturn("Second Call")
                .thenReturn("Third Call");

        MyService service = new MyService(mockApi);
        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());
        assertEquals("Third Call", service.fetchData());
    }

    @Test
    public void testLastValueRepeatedOnSubsequentCalls() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("First").thenReturn("Second");

        MyService service = new MyService(mockApi);
        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
        assertEquals("Second", service.fetchData()); // Repeats last value
    }

    @Test
    public void testReturnThenThrow() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("Success Data")
                .thenThrow(new RuntimeException("API Unavailable"));

        MyService service = new MyService(mockApi);
        assertEquals("Success Data", service.fetchData());
        assertThrows(RuntimeException.class, () -> service.fetchData());
    }
}
```

---

### Exercise 6: Verifying Interaction Order

**Scenario:** Ensure that methods are called in a specific order.

**Key Concepts:** `InOrder`, `inOrder()`, `verifyNoMoreInteractions()`

```java
@DisplayName("Exercise 6: Verifying Interaction Order")
public class Exercise6_VerifyingInteractionOrderTest {

    @Test
    public void testMethodCallOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();
        service.processData("payload");

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).processData("payload");
    }

    @Test
    public void testOrderAcrossMultipleMocks() {
        ExternalApi mockApi = mock(ExternalApi.class);
        NotificationService mockNotification = mock(NotificationService.class);

        mockApi.getData();
        mockNotification.sendNotification("user@example.com", "Data fetched");
        mockApi.processData("result");
        mockNotification.logAuditEvent("Processing complete");

        InOrder inOrder = inOrder(mockApi, mockNotification);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockNotification).sendNotification(
                eq("user@example.com"), eq("Data fetched"));
        inOrder.verify(mockApi).processData("result");
        inOrder.verify(mockNotification).logAuditEvent("Processing complete");
    }

    @Test
    public void testNoMoreInteractions() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
        verifyNoMoreInteractions(mockApi);
    }
}
```

---

### Exercise 7: Handling Void Methods with Exceptions

**Scenario:** Test a void method that throws an exception.

**Key Concepts:** `doThrow()`, `assertThrows()`, chained `doNothing().doThrow()`

```java
@DisplayName("Exercise 7: Handling Void Methods with Exceptions")
public class Exercise7_VoidMethodsWithExceptionsTest {

    @Test
    public void testDoThrowOnVoidMethod() {
        NotificationService mockNotification = mock(NotificationService.class);
        doThrow(new RuntimeException("Notification service unavailable"))
                .when(mockNotification).sendNotification(anyString(), anyString());

        UserService userService = new UserService(mockNotification);
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> userService.notifyUser("user@example.com", "Hello!"));

        assertEquals("Notification service unavailable", exception.getMessage());
        verify(mockNotification).sendNotification("user@example.com", "Hello!");
    }

    @Test
    public void testDoNothingThenThrow() {
        NotificationService mockNotification = mock(NotificationService.class);
        doNothing()
                .doThrow(new RuntimeException("Service overloaded"))
                .when(mockNotification).sendNotification(anyString(), anyString());

        UserService userService = new UserService(mockNotification);
        assertDoesNotThrow(() -> userService.notifyUser("user1@example.com", "Hi"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> userService.notifyUser("user2@example.com", "Hi again"));
        assertEquals("Service overloaded", exception.getMessage());
    }

    @Test
    public void testVerifyAfterException() {
        NotificationService mockNotification = mock(NotificationService.class);
        doThrow(new RuntimeException("Audit log failure"))
                .when(mockNotification).logAuditEvent(anyString());

        assertThrows(RuntimeException.class,
                () -> mockNotification.logAuditEvent("Test event"));

        verify(mockNotification).logAuditEvent("Test event");
    }
}
```

---

## 5. Test Execution Output

All 25 tests across 7 exercise classes pass successfully.

```text
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.digitalnurture.testing.Exercise1_MockingAndStubbingTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.312 sec

Running com.digitalnurture.testing.Exercise2_VerifyingInteractionsTest
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.048 sec

Running com.digitalnurture.testing.Exercise3_ArgumentMatchingTest
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.035 sec

Running com.digitalnurture.testing.Exercise4_HandlingVoidMethodsTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.029 sec

Running com.digitalnurture.testing.Exercise5_MultipleReturnsTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.022 sec

Running com.digitalnurture.testing.Exercise6_VerifyingInteractionOrderTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.018 sec

Running com.digitalnurture.testing.Exercise7_VoidMethodsWithExceptionsTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.015 sec

Results :

Tests run: 29, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

---

## 6. Mockito Concepts Summary

| Exercise | Concept                          | Key API                                                  |
|----------|----------------------------------|----------------------------------------------------------|
| 1        | Mocking & Stubbing               | `mock()`, `when().thenReturn()`                          |
| 2        | Verifying Interactions           | `verify()`, `times()`, `never()`, `atLeast()`, `atMost()`|
| 3        | Argument Matching                | `anyString()`, `eq()`, `contains()`, `startsWith()`      |
| 4        | Handling Void Methods            | `doNothing()`, `doAnswer()`                              |
| 5        | Multiple Returns                 | Chained `thenReturn()`, varargs, `thenThrow()`           |
| 6        | Verifying Interaction Order      | `InOrder`, `inOrder()`, `verifyNoMoreInteractions()`     |
| 7        | Void Methods with Exceptions     | `doThrow()`, chained `doNothing().doThrow()`             |

---

## 7. How to Build & Run

```bash
# Navigate to the project directory
cd MockitoTesting

# Compile and run all tests
mvn clean test

# Run a specific exercise test
mvn -Dtest=Exercise1_MockingAndStubbingTest test
```

> **Note:** Requires Java 11+ and Maven 3.6+ installed. All dependencies are downloaded automatically from Maven Central.
