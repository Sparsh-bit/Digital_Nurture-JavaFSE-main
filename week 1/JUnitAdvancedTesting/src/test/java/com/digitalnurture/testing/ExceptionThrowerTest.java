package com.digitalnurture.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link ExceptionThrower} demonstrating exception testing in JUnit 5.
 * <p>
 * This class verifies that methods throw the expected exceptions under specific
 * conditions. JUnit 5 provides the {@code assertThrows} method which is the
 * recommended approach for testing exceptions, replacing the older JUnit 4
 * {@code @Test(expected = ...)} and {@code @Rule ExpectedException} mechanisms.
 * </p>
 * <p>
 * <b>Key Concepts Demonstrated:</b>
 * <ul>
 *     <li>{@code assertThrows} — asserts that the execution of a lambda throws the expected exception</li>
 *     <li>Exception message verification — validates the content of the exception message</li>
 *     <li>Testing multiple exception types from a single class</li>
 * </ul>
 * </p>
 *
 * @author Digital Nurture
 * @version 1.0
 */
class ExceptionThrowerTest {

    private ExceptionThrower exceptionThrower;

    @BeforeEach
    void setUp() {
        exceptionThrower = new ExceptionThrower();
    }

    /**
     * Verifies that {@link ExceptionThrower#throwException()} throws
     * an {@link IllegalArgumentException}.
     */
    @Test
    @DisplayName("throwException() should throw IllegalArgumentException")
    void testThrowException_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> exceptionThrower.throwException(),
                "Expected throwException() to throw IllegalArgumentException");
    }

    /**
     * Verifies that the exception thrown by {@link ExceptionThrower#throwException()}
     * contains the expected error message.
     */
    @Test
    @DisplayName("throwException() should contain correct error message")
    void testThrowException_hasCorrectMessage() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> exceptionThrower.throwException()
        );
        assertEquals("Invalid argument provided", exception.getMessage(),
                "Exception message should match expected text");
    }

    /**
     * Verifies that {@link ExceptionThrower#validateInput(String)} throws
     * a {@link NullPointerException} when passed a null argument.
     */
    @Test
    @DisplayName("validateInput(null) should throw NullPointerException")
    void testValidateInput_withNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> exceptionThrower.validateInput(null),
                "Expected validateInput(null) to throw NullPointerException");
    }

    /**
     * Verifies that {@link ExceptionThrower#validateInput(String)} throws
     * an {@link IllegalArgumentException} when passed an empty string.
     */
    @Test
    @DisplayName("validateInput('') should throw IllegalArgumentException")
    void testValidateInput_withEmptyString_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> exceptionThrower.validateInput(""),
                "Expected validateInput('') to throw IllegalArgumentException");
    }
}
