package com.digitalnurture.advancedtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Exercise 4: Mocking Network Interactions
 *
 * Scenario: You need to test a service that interacts with network resources.
 * Steps:
 *   1. Create a mock network client using Mockito.
 *   2. Stub the network client methods to simulate network interactions.
 *   3. Write a test to verify the service logic using the mocked network client.
 */
@DisplayName("Exercise 4: Mocking Network Interactions")
public class Exercise4_MockNetworkClientTest {

    @Test
    @DisplayName("Should successfully connect to server using a mocked network client")
    public void testServiceWithMockNetworkClient() {
        // 1. Create a mock network client using Mockito.
        NetworkClient mockNetworkClient = mock(NetworkClient.class);

        // 2. Stub the network client methods to simulate network interactions.
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // 3. Write a test to verify the service logic using the mocked network client.
        NetworkService networkService = new NetworkService(mockNetworkClient);
        String result = networkService.connectToServer();

        assertEquals("Connected to Mock Connection", result);

        // Verify interface invocation
        verify(mockNetworkClient, times(1)).connect();
    }
}
