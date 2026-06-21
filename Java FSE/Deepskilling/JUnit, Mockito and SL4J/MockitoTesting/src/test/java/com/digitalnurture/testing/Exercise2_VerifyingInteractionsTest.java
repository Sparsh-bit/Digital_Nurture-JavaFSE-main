package com.digitalnurture.testing;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Exercise 2: Verifying Interactions
 *
 * Scenario: Ensure that a method is called with specific arguments.
 *
 * Steps:
 *   1. Create a mock object.
 *   2. Call the method with specific arguments.
 *   3. Verify the interaction.
 */
@DisplayName("Exercise 2: Verifying Interactions")
public class Exercise2_VerifyingInteractionsTest {

    @Test
    @DisplayName("Should verify that getData() is called exactly once")
    public void testVerifyInteraction() {
        // 1. Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Call the method
        MyService service = new MyService(mockApi);
        service.fetchData();

        // 3. Verify the interaction
        verify(mockApi).getData();
    }

    @Test
    @DisplayName("Should verify that getData(key) is called with the correct argument")
    public void testVerifyInteractionWithArguments() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData("testKey");

        // Verify called with exact argument
        verify(mockApi).getData("testKey");
    }

    @Test
    @DisplayName("Should verify the exact number of method invocations")
    public void testVerifyNumberOfInvocations() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Call fetchData three times
        service.fetchData();
        service.fetchData();
        service.fetchData();

        // Verify getData() was called exactly 3 times
        verify(mockApi, times(3)).getData();
    }

    @Test
    @DisplayName("Should verify that a method was never called")
    public void testVerifyNoInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Do not call any methods on the service
        // Verify getData() was never called
        verify(mockApi, never()).getData();
    }

    @Test
    @DisplayName("Should verify at least / at most invocation counts")
    public void testVerifyAtLeastAtMost() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();
        service.fetchData();

        // Verify at least 1 invocation
        verify(mockApi, atLeast(1)).getData();

        // Verify at most 3 invocations
        verify(mockApi, atMost(3)).getData();
    }
}
