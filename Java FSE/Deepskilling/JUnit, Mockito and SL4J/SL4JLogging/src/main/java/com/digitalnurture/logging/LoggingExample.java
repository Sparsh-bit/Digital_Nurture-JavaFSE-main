package com.digitalnurture.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 1: Logging Error Messages and Warning Levels
 *
 * Demonstrates logging error and warning level statements using the SLF4J API.
 */
public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Log an error level statement
        logger.error("This is an error message");

        // Log a warning level statement
        logger.warn("This is a warning message");
    }
}
