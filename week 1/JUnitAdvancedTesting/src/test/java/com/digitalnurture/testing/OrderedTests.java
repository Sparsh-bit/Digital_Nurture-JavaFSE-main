package com.digitalnurture.testing;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class demonstrating controlled test execution order using JUnit 5.
 * <p>
 * By default, JUnit does not guarantee the execution order of test methods.
 * This class uses the {@code @TestMethodOrder} annotation with
 * {@link MethodOrderer.OrderAnnotation} to enforce a specific sequence
 * via the {@code @Order} annotation on each test method.
 * </p>
 * <p>
 * <b>Key Concepts Demonstrated:</b>
 * <ul>
 *     <li>{@code @TestMethodOrder} — specifies the ordering strategy for test methods</li>
 *     <li>{@code @Order} — assigns a numeric priority to each test method</li>
 * </ul>
 * </p>
 * <p>
 * <b>Note:</b> While ordering tests can be useful for integration or smoke tests,
 * unit tests should ideally remain independent and not rely on execution order.
 * </p>
 *
 * @author Digital Nurture
 * @version 1.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTests {

    /**
     * First test in the ordered sequence.
     * Verifies basic addition to confirm the test environment is operational.
     */
    @Test
    @Order(1)
    void testAddition_executesFirst() {
        int result = 5 + 3;
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    /**
     * Second test in the ordered sequence.
     * Verifies string concatenation behavior.
     */
    @Test
    @Order(2)
    void testStringConcatenation_executesSecond() {
        String greeting = "Hello" + " " + "World";
        assertEquals("Hello World", greeting,
                "String concatenation should produce 'Hello World'");
    }

    /**
     * Third test in the ordered sequence.
     * Verifies that a non-null object is produced correctly.
     */
    @Test
    @Order(3)
    void testObjectCreation_executesThird() {
        Object obj = new Object();
        assertNotNull(obj, "Newly created object should not be null");
    }

    /**
     * Fourth test in the ordered sequence.
     * Verifies boolean condition evaluation.
     */
    @Test
    @Order(4)
    void testBooleanLogic_executesFourth() {
        boolean condition = (10 > 5) && (3 < 7);
        assertTrue(condition,
                "Compound boolean expression should evaluate to true");
    }

    /**
     * Fifth and final test in the ordered sequence.
     * Verifies array length after initialization.
     */
    @Test
    @Order(5)
    void testArrayLength_executesFifth() {
        int[] numbers = {1, 2, 3, 4, 5};
        assertEquals(5, numbers.length,
                "Array should contain exactly 5 elements");
    }
}
