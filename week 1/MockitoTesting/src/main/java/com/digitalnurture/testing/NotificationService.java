package com.digitalnurture.testing;

/**
 * Represents a notification service dependency.
 * This interface simulates a service with void methods for
 * Exercises 4 (Handling Void Methods) and 7 (Void Methods with Exceptions).
 */
public interface NotificationService {

    /**
     * Sends a notification message to the specified recipient.
     *
     * @param recipient the recipient of the notification
     * @param message   the notification message
     */
    void sendNotification(String recipient, String message);

    /**
     * Sends an email notification.
     *
     * @param emailAddress the target email address
     * @param subject      the email subject
     * @param body         the email body
     */
    void sendEmail(String emailAddress, String subject, String body);

    /**
     * Logs an audit event for tracking purposes.
     *
     * @param event the audit event description
     */
    void logAuditEvent(String event);
}
