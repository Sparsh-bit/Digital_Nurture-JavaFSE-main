package com.digitalnurture.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 3: Using Different Appenders
 *
 * Demonstrates logging messages across multiple configured Logback appenders (Console and File).
 */
public class AppendersLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(AppendersLoggingExample.class);

    public static void main(String[] args) {
        logger.debug("Starting application logging checks...");
        
        logger.info("This is an information message written to console and file appenders.");
        
        logger.warn("This is a warning log indicating potential system adjustments.");
        
        logger.error("This is an error log illustrating problem capture in log outputs.");
    }
}
