package com.digitalnurture.testing;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Exercise 4: Handling Void Methods
 *
 * Scenario: Test a void method that performs some action.
 *
 * Steps:
 *   1. Create a mock object.
 *   2. Stub the void method.
 *   3. Verify the interaction.
 */
@DisplayName("Exercise 4: Handling Void Methods")
public class Exercise4_HandlingVoidMethodsTest {

    @Test
    @DisplayName("Should stub and verify void method using doNothing()")
    public void testDoNothingOnVoidMethod() {
        // 1. Create a mock object
        NotificationService mockNotification = mock(NotificationService.class);

        // 2. Stub the void method with doNothing() (default behavior, explicit here)
        doNothing().when(mockNotification).sendNotification(anyString(), anyString());

        // 3. Call the method and verify the interaction
        UserService userService = new UserService(mockNotification);
        userService.notifyUser("user@example.com", "Hello!");

        verify(mockNotification).sendNotification("user@example.com", "Hello!");
    }

    @Test
    @DisplayName("Should verify void method is called during user registration")
    public void testVoidMethodCalledDuringRegistration() {
        NotificationService mockNotification = mock(NotificationService.class);
        UserService userService = new UserService(mockNotification);

        // Perform registration which triggers void methods
        userService.registerUser("john_doe", "john@example.com");

        // Verify sendNotification was called with expected arguments
        verify(mockNotification).sendNotification(
                eq("john@example.com"),
                eq("Welcome, john_doe!"));

        // Verify audit logging was also called
        verify(mockNotification).logAuditEvent("User registered: john_doe");
    }

    @Test
    @DisplayName("Should verify void method using doAnswer() for custom behavior")
    public void testDoAnswerOnVoidMethod() {
        NotificationService mockNotification = mock(NotificationService.class);

        // Use doAnswer() to execute custom logic when void method is called
        doAnswer(invocation -> {
            String recipient = invocation.getArgument(0);
            String message = invocation.getArgument(1);
            // Custom verification logic within the answer
            assert recipient != null : "Recipient should not be null";
            assert message.contains("Welcome") : "Message should contain 'Welcome'";
            return null;
        }).when(mockNotification).sendNotification(anyString(), anyString());

        UserService userService = new UserService(mockNotification);
        userService.registerUser("jane_doe", "jane@example.com");

        verify(mockNotification).sendNotification(anyString(), contains("Welcome"));
    }

    @Test
    @DisplayName("Should verify multiple void method calls in sequence")
    public void testMultipleVoidMethodCalls() {
        NotificationService mockNotification = mock(NotificationService.class);
        UserService userService = new UserService(mockNotification);

        userService.resetPassword("user@example.com");

        // Verify both void methods were called
        verify(mockNotification).sendEmail(
                eq("user@example.com"),
                eq("Password Reset"),
                eq("Click the link to reset your password."));
        verify(mockNotification).logAuditEvent("Password reset requested for: user@example.com");
    }
}
