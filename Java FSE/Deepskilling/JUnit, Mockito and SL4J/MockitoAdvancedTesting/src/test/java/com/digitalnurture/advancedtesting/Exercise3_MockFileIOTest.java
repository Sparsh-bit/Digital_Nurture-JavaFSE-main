package com.digitalnurture.advancedtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Exercise 3: Mocking File I/O
 *
 * Scenario: You need to test a service that reads from and writes to files.
 * Steps:
 *   1. Create a mock file reader and writer using Mockito.
 *   2. Stub the file reader and writer methods to simulate file operations.
 *   3. Write a test to verify the service logic using the mocked file reader and writer.
 */
@DisplayName("Exercise 3: Mocking File I/O")
public class Exercise3_MockFileIOTest {

    @Test
    @DisplayName("Should successfully process files using mocked reader and writer")
    public void testServiceWithMockFileIO() {
        // 1. Create a mock file reader and writer using Mockito.
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        // 2. Stub the file reader and writer methods to simulate file operations.
        when(mockFileReader.read()).thenReturn("Mock File Content");
        // For void methods like FileWriter.write(String), we can either use doNothing() or rely on default Mockito behavior.
        doNothing().when(mockFileWriter).write(anyString());

        // 3. Write a test to verify the service logic using the mocked file reader and writer.
        FileService fileService = new FileService(mockFileReader, mockFileWriter);
        String result = fileService.processFile();

        assertEquals("Processed Mock File Content", result);

        // Verify interactions
        verify(mockFileReader, times(1)).read();
        verify(mockFileWriter, times(1)).write("Processed Mock File Content");
    }
}
