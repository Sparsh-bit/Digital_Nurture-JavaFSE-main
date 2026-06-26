package com.digitalnurture.advancedtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Exercise 2: Mocking External Services (RESTful APIs)
 *
 * Scenario: You need to test a service that calls an external RESTful API.
 * Steps:
 *   1. Create a mock REST client using Mockito.
 *   2. Stub the REST client methods to return predefined responses.
 *   3. Write a test to verify the service logic using the mocked REST client.
 */
@DisplayName("Exercise 2: Mocking External Services (RESTful APIs)")
public class Exercise2_MockRestClientTest {

    @Test
    @DisplayName("Should successfully fetch data using a mocked REST client")
    public void testServiceWithMockRestClient() {
        // 1. Create a mock REST client using Mockito.
        RestClient mockRestClient = mock(RestClient.class);

        // 2. Stub the REST client methods to return predefined responses.
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // 3. Write a test to verify the service logic using the mocked REST client.
        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.fetchData();

        assertEquals("Fetched Mock Response", result);
        
        // Optional verification: ensure mockRestClient.getResponse() was called.
        verify(mockRestClient, times(1)).getResponse();
    }
}
