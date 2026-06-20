package com.digitalnurture.testing;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Test suite that groups all advanced testing exercise test classes together.
 * <p>
 * This suite aggregates multiple test classes into a single execution unit,
 * allowing them to be run collectively with a single command or IDE action.
 * JUnit 5 uses the {@code @Suite} annotation (from the JUnit Platform Suite API)
 * along with {@code @SelectClasses} to define which test classes are included.
 * </p>
 * <p>
 * <b>Key Concepts Demonstrated:</b>
 * <ul>
 *     <li>{@code @Suite} — marks this class as a test suite entry point</li>
 *     <li>{@code @SelectClasses} — specifies the individual test classes to include in the suite</li>
 * </ul>
 * </p>
 * <p>
 * <b>Included Test Classes:</b>
 * <ol>
 *     <li>{@link EvenCheckerTest} — Parameterized tests for even/odd number checking</li>
 *     <li>{@link OrderedTests} — Tests with controlled execution order</li>
 *     <li>{@link ExceptionThrowerTest} — Exception testing scenarios</li>
 *     <li>{@link PerformanceTesterTest} — Timeout and performance validation tests</li>
 * </ol>
 * </p>
 *
 * @author Digital Nurture
 * @version 1.0
 */
@Suite
@SelectClasses({
        EvenCheckerTest.class,
        OrderedTests.class,
        ExceptionThrowerTest.class,
        PerformanceTesterTest.class
})
class AllTests {
    // This class serves as the suite definition.
    // No additional code is required — the annotations handle class selection.
}
