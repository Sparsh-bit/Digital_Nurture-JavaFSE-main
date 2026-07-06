package com.digitalnurture.testing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test class for Calculator using JUnit 4.
 */
public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(10, 20);
        assertEquals("10 + 20 should equal 30", 30, result);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(50, 20);
        assertEquals("50 - 20 should equal 30", 30, result);
    }
}
