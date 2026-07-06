package com.digitalnurture.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 2: Parameterized Logging
 *
 * Demonstrates high-performance parameterized logging using SLF4J curly braces placeholders.
 */
public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "JohnDoe";
        String ipAddress = "192.168.1.50";
        int failedAttempts = 3;

        // Logging parameters without string concatenation overhead
        logger.info("User '{}' logged in successfully from IP: {}", username, ipAddress);

        logger.warn("Security Alert: User '{}' failed login attempt #{}", username, failedAttempts);
    }
}
