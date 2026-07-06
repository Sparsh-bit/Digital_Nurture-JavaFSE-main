package com.digitalnurture.testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Exercise 5: Mocking and Stubbing with Multiple Returns
 *
 * Scenario: Test a service that depends on an external API with multiple return values.
 *
 * Steps:
 *   1. Create a mock object for the external API.
 *   2. Stub the methods to return different values on consecutive calls.
 *   3. Write a test case that uses the mock object.
 */
@DisplayName("Exercise 5: Mocking and Stubbing with Multiple Returns")
public class Exercise5_MultipleReturnsTest {

    @Test
    @DisplayName("Should return different values on consecutive calls using thenReturn()")
    public void testConsecutiveReturns() {
        // 1. Create a mock object for the external API
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the method to return different values on consecutive calls
        when(mockApi.getData())
                .thenReturn("First Call")
                .thenReturn("Second Call")
                .thenReturn("Third Call");

        // 3. Write a test case that uses the mock object
        MyService service = new MyService(mockApi);

        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());
        assertEquals("Third Call", service.fetchData());
    }

    @Test
    @DisplayName("Should return last stubbed value for all subsequent calls")
    public void testLastValueRepeatedOnSubsequentCalls() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Only two return values defined
        when(mockApi.getData())
                .thenReturn("First")
                .thenReturn("Second");

        MyService service = new MyService(mockApi);

        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
        // Subsequent calls return the last stubbed value
        assertEquals("Second", service.fetchData());
        assertEquals("Second", service.fetchData());
    }

    @Test
    @DisplayName("Should return multiple values using varargs in a single thenReturn()")
    public void testMultipleReturnsInSingleCall() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Varargs form of thenReturn
        when(mockApi.getData()).thenReturn("Alpha", "Beta", "Gamma");

        MyService service = new MyService(mockApi);

        assertEquals("Alpha", service.fetchData());
        assertEquals("Beta", service.fetchData());
        assertEquals("Gamma", service.fetchData());
    }

    @Test
    @DisplayName("Should handle thenReturn followed by thenThrow for error simulation")
    public void testReturnThenThrow() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // First call succeeds, second call throws an exception
        when(mockApi.getData())
                .thenReturn("Success Data")
                .thenThrow(new RuntimeException("API Unavailable"));

        MyService service = new MyService(mockApi);

        // First call returns successfully
        assertEquals("Success Data", service.fetchData());

        // Second call throws exception
        assertThrows(RuntimeException.class, () -> service.fetchData());
    }
}
