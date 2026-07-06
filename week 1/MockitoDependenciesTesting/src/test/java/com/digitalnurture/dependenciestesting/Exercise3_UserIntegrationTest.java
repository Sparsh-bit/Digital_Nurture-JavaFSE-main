package com.digitalnurture.dependenciestesting;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Exercise 3: Mocking a Service Dependency in an Integration Test
 *
 * Task: Write an integration test for a Spring Boot application that mocks a service dependency using Mockito.
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Exercise 3: Mocking a Service Dependency in an Integration Test")
public class Exercise3_UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("Should fetch user details using mocked UserService inside integration testing context")
    public void testIntegrationWithMockedService() throws Exception {
        // Arrange
        User expectedUser = new User(1L, "Alice");
        when(userService.getUserById(1L)).thenReturn(expectedUser);

        // Act & Assert
        mockMvc.perform(get("/users/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Alice"));

        verify(userService, times(1)).getUserById(1L);
    }
}
