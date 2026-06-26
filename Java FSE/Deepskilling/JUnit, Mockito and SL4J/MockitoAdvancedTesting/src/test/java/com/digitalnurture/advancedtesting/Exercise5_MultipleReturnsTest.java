package com.digitalnurture.advancedtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Exercise 5: Mocking Multiple Return Values
 *
 * Scenario: You need to test a service that calls a method multiple times with different return values.
 * Steps:
 *   1. Create a mock object using Mockito.
 *   2. Stub the method to return different values on consecutive calls.
 *   3. Write a test to verify the service logic using the mocked object.
 */
@DisplayName("Exercise 5: Mocking Multiple Return Values")
public class Exercise5_MultipleReturnsTest {

    @Test
    @DisplayName("Should successfully return consecutive values on consecutive method calls")
    public void testServiceWithMultipleReturnValues() {
        // 1. Create a mock object using Mockito.
        Repository mockRepository = mock(Repository.class);

        // 2. Stub the method to return different values on consecutive calls.
        when(mockRepository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        // 3. Write a test to verify the service logic using the mocked object.
        Service service = new Service(mockRepository);
        String firstResult = service.processData();
        String secondResult = service.processData();

        assertEquals("Processed First Mock Data", firstResult);
        assertEquals("Processed Second Mock Data", secondResult);

        // Verify that getData() was called twice
        verify(mockRepository, times(2)).getData();
    }
}
