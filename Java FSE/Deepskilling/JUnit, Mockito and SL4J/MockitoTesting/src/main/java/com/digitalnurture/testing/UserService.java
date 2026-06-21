package com.digitalnurture.testing;

/**
 * Service class that depends on NotificationService.
 * Demonstrates handling of void method dependencies in testing.
 * Used in Exercises 4 and 7.
 */
public class UserService {

    private final NotificationService notificationService;

    /**
     * Constructs UserService with the given NotificationService dependency.
     *
     * @param notificationService the notification service to use
     */
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Registers a new user and sends a welcome notification.
     *
     * @param username the username of the new user
     * @param email    the email of the new user
     */
    public void registerUser(String username, String email) {
        // Business logic for user registration
        notificationService.sendNotification(email, "Welcome, " + username + "!");
        notificationService.logAuditEvent("User registered: " + username);
    }

    /**
     * Sends a password reset email to the user.
     *
     * @param email the email address to send the reset link to
     */
    public void resetPassword(String email) {
        notificationService.sendEmail(email, "Password Reset",
                "Click the link to reset your password.");
        notificationService.logAuditEvent("Password reset requested for: " + email);
    }

    /**
     * Notifies a user about an event.
     *
     * @param email   the user's email
     * @param message the notification message
     */
    public void notifyUser(String email, String message) {
        notificationService.sendNotification(email, message);
    }
}
