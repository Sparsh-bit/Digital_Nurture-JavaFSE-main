package com.digitalnurture.springtesting;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.NoSuchElementException;

/**
 * Exercise 8: Test Controller Exception Handling
 *
 * Task: Add and test a @ControllerAdvice for handling exceptions.
 */
@WebMvcTest(UserController.class)
@DisplayName("Exercise 8: Test Controller Exception Handling")
public class Exercise8_ControllerExceptionHandlingTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("Should successfully handle NoSuchElementException and return HTTP 404 with error body")
    public void testControllerAdviceExceptionHandling() throws Exception {
        // Arrange
        when(userService.getUserById(999L)).thenThrow(new NoSuchElementException("User not found"));

        // Act & Assert
        mockMvc.perform(get("/users/{id}", 999L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));

        verify(userService, times(1)).getUserById(999L);
    }
}
