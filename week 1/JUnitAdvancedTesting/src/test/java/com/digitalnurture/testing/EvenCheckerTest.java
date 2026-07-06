package com.digitalnurture.testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Parameterized test class for {@link EvenChecker}.
 * <p>
 * This test class demonstrates the use of JUnit 5's {@code @ParameterizedTest}
 * annotation in combination with {@code @ValueSource} to run the same test logic
 * against multiple input values. This approach eliminates the need for writing
 * repetitive individual test methods for each input scenario.
 * </p>
 * <p>
 * <b>Key Concepts Demonstrated:</b>
 * <ul>
 *     <li>{@code @ParameterizedTest} — marks a method as a parameterized test</li>
 *     <li>{@code @ValueSource} — supplies a fixed array of literal values as arguments</li>
 * </ul>
 * </p>
 *
 * @author Digital Nurture
 * @version 1.0
 */
class EvenCheckerTest {

    private final EvenChecker evenChecker = new EvenChecker();

    /**
     * Verifies that {@link EvenChecker#isEven(int)} returns {@code true}
     * for a range of known even numbers including zero and negative values.
     *
     * @param number the even number to test
     */
    @ParameterizedTest(name = "isEven({0}) should return true")
    @ValueSource(ints = {0, 2, 4, 10, 100, -2, -8, 1024})
    void testIsEven_withEvenNumbers(int number) {
        assertTrue(evenChecker.isEven(number),
                () -> number + " should be identified as even");
    }

    /**
     * Verifies that {@link EvenChecker#isEven(int)} returns {@code false}
     * for a range of known odd numbers including negative values.
     *
     * @param number the odd number to test
     */
    @ParameterizedTest(name = "isEven({0}) should return false")
    @ValueSource(ints = {1, 3, 5, 11, 99, -1, -7, 1023})
    void testIsEven_withOddNumbers(int number) {
        assertFalse(evenChecker.isEven(number),
                () -> number + " should be identified as odd");
    }
}
