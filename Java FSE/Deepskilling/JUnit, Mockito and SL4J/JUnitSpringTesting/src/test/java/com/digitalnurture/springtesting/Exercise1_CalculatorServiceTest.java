package com.digitalnurture.springtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Exercise 1: Basic Unit Test for a Service Method
 *
 * Task: Write a unit test for a service method that adds two numbers.
 */
@DisplayName("Exercise 1: Basic Unit Test for a Service Method")
public class Exercise1_CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("Should correctly add two positive integers")
    public void testAdd() {
        int result = calculatorService.add(5, 10);
        assertEquals(15, result, "5 + 10 should equal 15");
    }
}
