package com.digitalnurture.testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Exercise 1: Mocking and Stubbing
 *
 * Scenario: Test a service that depends on an external API.
 *           Use Mockito to mock the external API and stub its methods.
 *
 * Steps:
 *   1. Create a mock object for the external API.
 *   2. Stub the methods to return predefined values.
 *   3. Write a test case that uses the mock object.
 */
@DisplayName("Exercise 1: Mocking and Stubbing")
public class Exercise1_MockingAndStubbingTest {

    @Test
    @DisplayName("Should return stubbed data from mocked ExternalApi")
    public void testExternalApi() {
        // 1. Create a mock object for the external API
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub the method to return a predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Write a test case that uses the mock object
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    @DisplayName("Should return different stubbed values for different method signatures")
    public void testStubbingWithArguments() {
        // Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub with specific arguments
        when(mockApi.getData("user")).thenReturn("User Data");
        when(mockApi.getData("admin")).thenReturn("Admin Data");

        // Verify stubbed behavior
        MyService service = new MyService(mockApi);
        assertEquals("User Data", service.fetchData("user"));
        assertEquals("Admin Data", service.fetchData("admin"));
    }

    @Test
    @DisplayName("Should return null for unstubbed methods by default")
    public void testDefaultReturnForUnstubbedMethods() {
        // Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Unstubbed methods return null for objects
        MyService service = new MyService(mockApi);
        assertNull(service.fetchData());
    }
}
