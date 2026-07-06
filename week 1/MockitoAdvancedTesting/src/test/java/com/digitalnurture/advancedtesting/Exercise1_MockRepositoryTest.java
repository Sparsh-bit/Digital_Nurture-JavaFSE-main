package com.digitalnurture.advancedtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Exercise 1: Mocking Databases and Repositories
 *
 * Scenario: You need to test a service that interacts with a database repository.
 * Steps:
 *   1. Create a mock repository using Mockito.
 *   2. Stub the repository methods to return predefined data.
 *   3. Write a test to verify the service logic using the mocked repository.
 */
@DisplayName("Exercise 1: Mocking Databases and Repositories")
public class Exercise1_MockRepositoryTest {

    @Test
    @DisplayName("Should successfully process data using a mocked repository")
    public void testServiceWithMockRepository() {
        // 1. Create a mock repository using Mockito.
        Repository mockRepository = mock(Repository.class);

        // 2. Stub the repository methods to return predefined data.
        when(mockRepository.getData()).thenReturn("Mock Data");

        // 3. Write a test to verify the service logic using the mocked repository.
        Service service = new Service(mockRepository);
        String result = service.processData();

        assertEquals("Processed Mock Data", result);
        
        // Optional verification: ensure mockRepository.getData() was called exactly once.
        verify(mockRepository, times(1)).getData();
    }
}
