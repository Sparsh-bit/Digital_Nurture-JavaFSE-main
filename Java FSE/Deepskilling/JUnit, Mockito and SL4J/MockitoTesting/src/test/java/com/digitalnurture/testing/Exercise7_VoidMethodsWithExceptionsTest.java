package com.digitalnurture.testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Exercise 7: Handling Void Methods with Exceptions
 *
 * Scenario: Test a void method that throws an exception.
 *
 * Steps:
 *   1. Create a mock object.
 *   2. Stub the void method to throw an exception.
 *   3. Verify the interaction.
 */
@DisplayName("Exercise 7: Handling Void Methods with Exceptions")
public class Exercise7_VoidMethodsWithExceptionsTest {

    @Test
    @DisplayName("Should throw exception when void method is stubbed with doThrow()")
    public void testDoThrowOnVoidMethod() {
        // 1. Create a mock object
        NotificationService mockNotification = mock(NotificationService.class);

        // 2. Stub the void method to throw an exception
        doThrow(new RuntimeException("Notification service unavailable"))
                .when(mockNotification).sendNotification(anyString(), anyString());

        // 3. Verify the interaction — exception is thrown
        UserService userService = new UserService(mockNotification);
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> userService.notifyUser("user@example.com", "Hello!"));

        assertEquals("Notification service unavailable", exception.getMessage());
        verify(mockNotification).sendNotification("user@example.com", "Hello!");
    }

    @Test
    @DisplayName("Should throw checked exception using doThrow() on void method")
    public void testDoThrowCheckedException() {
        NotificationService mockNotification = mock(NotificationService.class);

        // Stub to throw a checked exception (wrapped as RuntimeException)
        doThrow(new IllegalStateException("Email server down"))
                .when(mockNotification).sendEmail(anyString(), anyString(), anyString());

        UserService userService = new UserService(mockNotification);

        assertThrows(IllegalStateException.class,
                () -> userService.resetPassword("user@example.com"));
    }

    @Test
    @DisplayName("Should throw exception only on second invocation of void method")
    public void testDoNothingThenThrow() {
        NotificationService mockNotification = mock(NotificationService.class);

        // First call does nothing, second call throws exception
        doNothing()
                .doThrow(new RuntimeException("Service overloaded"))
                .when(mockNotification).sendNotification(anyString(), anyString());

        UserService userService = new UserService(mockNotification);

        // First call succeeds
        assertDoesNotThrow(() -> userService.notifyUser("user1@example.com", "Hi"));

        // Second call throws exception
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> userService.notifyUser("user2@example.com", "Hi again"));

        assertEquals("Service overloaded", exception.getMessage());
    }

    @Test
    @DisplayName("Should verify void method interaction even when exception is thrown")
    public void testVerifyAfterException() {
        NotificationService mockNotification = mock(NotificationService.class);

        doThrow(new RuntimeException("Audit log failure"))
                .when(mockNotification).logAuditEvent(anyString());

        // Call directly on mock to trigger exception
        assertThrows(RuntimeException.class,
                () -> mockNotification.logAuditEvent("Test event"));

        // Verify the method was still invoked
        verify(mockNotification).logAuditEvent("Test event");
    }
}
