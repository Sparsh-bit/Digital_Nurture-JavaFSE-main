package com.digitalnurture.dependenciestesting;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Exercise 1: Mocking a Service Dependency in a Controller Test
 *
 * Task: Write a unit test for a Spring controller that uses a service to fetch data.
 *       Mock the service dependency using Mockito.
 */
@WebMvcTest(UserController.class)
@DisplayName("Exercise 1: Mocking a Service Dependency in a Controller Test")
public class Exercise1_UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("Should return mocked user when GET request is executed")
    public void testGetUser() throws Exception {
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
