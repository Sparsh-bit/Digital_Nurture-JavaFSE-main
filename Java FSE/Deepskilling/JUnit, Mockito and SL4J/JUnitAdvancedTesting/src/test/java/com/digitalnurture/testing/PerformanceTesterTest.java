package com.digitalnurture.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link PerformanceTester} demonstrating timeout and performance
 * testing capabilities in JUnit 5.
 * <p>
 * This class uses JUnit 5's timeout assertions to verify that methods complete
 * within an acceptable time frame. Two approaches are demonstrated:
 * <ul>
 *     <li>{@code assertTimeout} — waits for the executable to complete, then checks
 *         if it exceeded the timeout (does not abort execution)</li>
 *     <li>{@code assertTimeoutPreemptively} — aborts execution immediately if the
 *         timeout is exceeded (runs in a separate thread)</li>
 * </ul>
 * </p>
 * <p>
 * <b>Key Concepts Demonstrated:</b>
 * <ul>
 *     <li>Timeout assertions for performance validation</li>
 *     <li>Difference between {@code assertTimeout} and {@code assertTimeoutPreemptively}</li>
 *     <li>Testing that operations complete within SLA boundaries</li>
 * </ul>
 * </p>
 *
 * @author Digital Nurture
 * @version 1.0
 */
class PerformanceTesterTest {

    private PerformanceTester performanceTester;

    @BeforeEach
    void setUp() {
        performanceTester = new PerformanceTester();
    }

    /**
     * Verifies that {@link PerformanceTester#performTask()} completes within
     * 2 seconds. Since the method sleeps for approximately 500ms, a 2-second
     * timeout provides a reasonable margin for execution overhead.
     */
    @Test
    @DisplayName("performTask() should complete within 2 seconds")
    void testPerformTask_completesWithinTimeout() {
        assertTimeout(Duration.ofSeconds(2),
                () -> performanceTester.performTask(),
                "performTask() should complete well within the 2-second limit");
    }

    /**
     * Verifies that {@link PerformanceTester#performTask()} completes within
     * 1 second using preemptive timeout. This variant aborts execution if the
     * timeout is exceeded, which is useful for preventing long-running tests
     * from blocking the entire test suite.
     */
    @Test
    @DisplayName("performTask() should complete within 1 second (preemptive)")
    void testPerformTask_completesWithinPreemptiveTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(1),
                () -> performanceTester.performTask(),
                "performTask() should finish before the preemptive 1-second cutoff");
    }

    /**
     * Verifies that {@link PerformanceTester#quickTask()} completes almost
     * instantaneously. A tight 100ms timeout is used to confirm that the
     * computation is genuinely fast.
     */
    @Test
    @DisplayName("quickTask() should complete within 100 milliseconds")
    void testQuickTask_completesRapidly() {
        int result = assertTimeoutPreemptively(Duration.ofMillis(100),
                () -> performanceTester.quickTask(),
                "quickTask() should complete within 100ms");
        assertEquals(500500, result,
                "Sum of 1 to 1000 should be 500500");
    }

    /**
     * Verifies that {@link PerformanceTester#performTask()} does not throw
     * any unexpected exceptions during normal execution.
     */
    @Test
    @DisplayName("performTask() should not throw exceptions")
    void testPerformTask_doesNotThrowException() {
        assertDoesNotThrow(
                () -> performanceTester.performTask(),
                "performTask() should execute without throwing any exception");
    }
}
