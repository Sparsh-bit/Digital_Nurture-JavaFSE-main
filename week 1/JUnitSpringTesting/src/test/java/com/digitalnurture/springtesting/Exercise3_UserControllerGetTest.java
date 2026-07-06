package com.digitalnurture.springtesting;

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
 * Exercise 3: Testing a REST Controller with MockMvc
 *
 * Task: Test a controller endpoint that returns a user.
 */
@WebMvcTest(UserController.class)
@DisplayName("Exercise 3: Testing a REST Controller with MockMvc")
public class Exercise3_UserControllerGetTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("Should successfully return User details as JSON response")
    public void testGetUser() throws Exception {
        // Arrange
        User user = new User(1L, "Alice");
        when(userService.getUserById(1L)).thenReturn(user);

        // Act & Assert
        mockMvc.perform(get("/users/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Alice"));

        verify(userService, times(1)).getUserById(1L);
    }
}
