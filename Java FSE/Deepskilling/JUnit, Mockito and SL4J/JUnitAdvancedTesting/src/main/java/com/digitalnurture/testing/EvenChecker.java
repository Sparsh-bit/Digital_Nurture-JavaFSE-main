package com.digitalnurture.testing;

/**
 * Utility class for checking whether a given integer is even or odd.
 * <p>
 * This class is used as a demonstration target for parameterized testing
 * with JUnit 5's {@code @ParameterizedTest} and {@code @ValueSource} annotations.
 * </p>
 *
 * @author Digital Nurture
 * @version 1.0
 */
public class EvenChecker {

    /**
     * Determines whether the specified number is even.
     *
     * @param number the integer to check
     * @return {@code true} if the number is divisible by 2 with no remainder;
     *         {@code false} otherwise
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}
