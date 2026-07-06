package com.digitalnurture.springtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Exercise 9: Parameterized Test with JUnit
 *
 * Task: Use @ParameterizedTest to test multiple inputs.
 */
@DisplayName("Exercise 9: Parameterized Test with JUnit")
public class Exercise9_ParameterizedCalculatorTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest(name = "Adding {0} and {1} should equal {2}")
    @CsvSource({
            "1, 2, 3",
            "5, 5, 10",
            "10, -3, 7",
            "-5, -5, -10",
            "0, 0, 0"
    })
    @DisplayName("Should correctly verify various addition inputs and outputs")
    public void testAddParameterized(int a, int b, int expectedSum) {
        int actualSum = calculatorService.add(a, b);
        assertEquals(expectedSum, actualSum, () -> String.format("%d + %d should yield %d", a, b, expectedSum));
    }
}
