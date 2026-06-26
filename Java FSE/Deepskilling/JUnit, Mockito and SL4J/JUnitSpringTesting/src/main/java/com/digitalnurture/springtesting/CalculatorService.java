package com.digitalnurture.springtesting;

import org.springframework.stereotype.Service;

/**
 * Service class performing calculator operations.
 */
@Service
public class CalculatorService {

    /**
     * Adds two integers.
     *
     * @param a first integer
     * @param b second integer
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }
}
