package com.digitalnurture.springtesting;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Exercise 5: Test Controller POST Endpoint
 *
 * Task: Test a POST endpoint that creates a user.
 */
@WebMvcTest(UserController.class)
@DisplayName("Exercise 5: Test Controller POST Endpoint")
public class Exercise5_UserControllerPostTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Should successfully create a User via HTTP POST and return details as JSON")
    public void testCreateUser() throws Exception {
        // Arrange
        User userToCreate = new User(2L, "Bob");
        when(userService.saveUser(any(User.class))).thenReturn(userToCreate);

        // Act & Assert
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userToCreate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("Bob"));

        verify(userService, times(1)).saveUser(any(User.class));
    }
}
