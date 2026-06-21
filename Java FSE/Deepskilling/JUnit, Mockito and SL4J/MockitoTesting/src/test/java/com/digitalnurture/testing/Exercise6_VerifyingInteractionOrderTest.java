package com.digitalnurture.testing;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

/**
 * Exercise 6: Verifying Interaction Order
 *
 * Scenario: Ensure that methods are called in a specific order.
 *
 * Steps:
 *   1. Create a mock object.
 *   2. Call the methods in a specific order.
 *   3. Verify the interaction order.
 */
@DisplayName("Exercise 6: Verifying Interaction Order")
public class Exercise6_VerifyingInteractionOrderTest {

    @Test
    @DisplayName("Should verify methods are called in the correct order")
    public void testMethodCallOrder() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. Call the methods in a specific order
        service.fetchData();
        service.processData("payload");

        // 3. Verify the interaction order using InOrder
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).processData("payload");
    }

    @Test
    @DisplayName("Should verify interaction order across multiple mock objects")
    public void testOrderAcrossMultipleMocks() {
        // Create two different mock objects
        ExternalApi mockApi = mock(ExternalApi.class);
        NotificationService mockNotification = mock(NotificationService.class);

        // Call methods in specific order across mocks
        mockApi.getData();
        mockNotification.sendNotification("user@example.com", "Data fetched");
        mockApi.processData("result");
        mockNotification.logAuditEvent("Processing complete");

        // Verify the order across both mocks
        InOrder inOrder = inOrder(mockApi, mockNotification);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockNotification).sendNotification(
                eq("user@example.com"), eq("Data fetched"));
        inOrder.verify(mockApi).processData("result");
        inOrder.verify(mockNotification).logAuditEvent("Processing complete");
    }

    @Test
    @DisplayName("Should verify user registration calls happen in order")
    public void testRegistrationOrder() {
        NotificationService mockNotification = mock(NotificationService.class);
        UserService userService = new UserService(mockNotification);

        // Register user — should call sendNotification THEN logAuditEvent
        userService.registerUser("alice", "alice@example.com");

        // Verify the order of interactions
        InOrder inOrder = inOrder(mockNotification);
        inOrder.verify(mockNotification).sendNotification(
                eq("alice@example.com"), contains("Welcome"));
        inOrder.verify(mockNotification).logAuditEvent(contains("User registered"));
    }

    @Test
    @DisplayName("Should verify no more interactions after verified calls")
    public void testNoMoreInteractions() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        // Verify the interaction
        verify(mockApi).getData();

        // Verify no additional interactions occurred
        verifyNoMoreInteractions(mockApi);
    }
}
