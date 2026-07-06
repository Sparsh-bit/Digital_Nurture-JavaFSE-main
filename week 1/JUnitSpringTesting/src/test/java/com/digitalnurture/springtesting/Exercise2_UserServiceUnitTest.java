package com.digitalnurture.springtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

/**
 * Exercise 2: Mocking a Repository in a Service Test
 *
 * Task: Test a service that uses a repository to fetch data.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Exercise 2: Mocking a Repository in a Service Test")
public class Exercise2_UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Should successfully fetch user by ID when user exists in repository")
    public void testGetUserById() {
        // Arrange
        User expectedUser = new User(1L, "Alice");
        when(userRepository.findById(1L)).thenReturn(Optional.of(expectedUser));

        // Act
        User result = userService.getUserById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Alice", result.getName());
        verify(userRepository, times(1)).findById(1L);
    }
}
