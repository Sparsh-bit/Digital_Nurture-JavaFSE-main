package com.digitalnurture.testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Exercise 3: Argument Matching
 *
 * Scenario: Verify that a method is called with specific arguments.
 *
 * Steps:
 *   1. Create a mock object.
 *   2. Call the method with specific arguments.
 *   3. Use argument matchers to verify the interaction.
 */
@DisplayName("Exercise 3: Argument Matching")
public class Exercise3_ArgumentMatchingTest {

    @Test
    @DisplayName("Should verify method call using anyString() matcher")
    public void testAnyStringMatcher() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub with any string argument
        when(mockApi.getData(anyString())).thenReturn("Matched Data");

        // 2. Call the method with specific arguments
        MyService service = new MyService(mockApi);
        String result = service.fetchData("anyKey");

        // 3. Use argument matchers to verify
        assertEquals("Matched Data", result);
        verify(mockApi).getData(anyString());
    }

    @Test
    @DisplayName("Should verify method call using eq() matcher for exact argument")
    public void testEqMatcher() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData(eq("specificKey"))).thenReturn("Specific Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData("specificKey");

        assertEquals("Specific Data", result);
        verify(mockApi).getData(eq("specificKey"));
    }

    @Test
    @DisplayName("Should verify method call using contains() matcher")
    public void testContainsMatcher() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData(contains("user"))).thenReturn("User Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData("user_123");

        assertEquals("User Data", result);
        verify(mockApi).getData(contains("user"));
    }

    @Test
    @DisplayName("Should verify method call using startsWith() matcher")
    public void testStartsWithMatcher() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData(startsWith("api_"))).thenReturn("API Response");

        MyService service = new MyService(mockApi);
        String result = service.fetchData("api_endpoint");

        assertEquals("API Response", result);
        verify(mockApi).getData(startsWith("api_"));
    }

    @Test
    @DisplayName("Should verify void method call using argument matchers")
    public void testArgumentMatcherWithVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.processData("test payload");

        // Verify processData was called with any string argument
        verify(mockApi).processData(anyString());
        // Verify processData was called with the exact argument
        verify(mockApi).processData(eq("test payload"));
    }
}
