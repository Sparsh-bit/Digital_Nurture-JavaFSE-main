package com.digitalnurture.springtesting;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Exercise 6: Test Service Exception Handling
 *
 * Task: Test how a service handles a missing user.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Exercise 6: Test Service Exception Handling")
public class Exercise6_UserServiceExceptionTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Should throw NoSuchElementException when user does not exist in repository")
    public void testGetUserByIdThrowsException() {
        // Arrange
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> {
            userService.getUserById(999L);
        }, "Should throw NoSuchElementException for non-existent users");

        verify(userRepository, times(1)).findById(999L);
    }
}
