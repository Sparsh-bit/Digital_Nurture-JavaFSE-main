package com.digitalnurture.testing;

/**
 * A class that intentionally throws exceptions for demonstration purposes.
 * <p>
 * This class is used to demonstrate JUnit 5's exception testing capabilities
 * using {@code assertThrows}. It provides methods that throw various types
 * of exceptions under specific conditions.
 * </p>
 *
 * @author Digital Nurture
 * @version 1.0
 */
public class ExceptionThrower {

    /**
     * Throws an {@link IllegalArgumentException} unconditionally.
     * <p>
     * This method is designed to simulate an error scenario where invalid
     * input or state causes an exception to be raised.
     * </p>
     *
     * @throws IllegalArgumentException always thrown with a descriptive message
     */
    public void throwException() {
        throw new IllegalArgumentException("Invalid argument provided");
    }

    /**
     * Validates the given input string and throws an exception if it is null or empty.
     *
     * @param input the string to validate
     * @throws NullPointerException     if the input is {@code null}
     * @throws IllegalArgumentException if the input is empty
     */
    public void validateInput(String input) {
        if (input == null) {
            throw new NullPointerException("Input must not be null");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input must not be empty");
        }
    }
}
