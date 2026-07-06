package com.digitalnurture.testing;

/**
 * A class that simulates a time-consuming computational task for performance testing.
 * <p>
 * This class is used to demonstrate JUnit 5's timeout assertions, which verify
 * that a method completes execution within a specified time limit. The
 * {@code performTask} method simulates a task by introducing a controlled delay.
 * </p>
 *
 * @author Digital Nurture
 * @version 1.0
 */
public class PerformanceTester {

    /**
     * Simulates a task that takes approximately 500 milliseconds to complete.
     * <p>
     * This method uses {@link Thread#sleep(long)} to simulate processing time.
     * In a real-world scenario, this could represent a database query, file I/O,
     * or a complex computation that needs to be performance-tested.
     * </p>
     *
     * @throws InterruptedException if the thread is interrupted during the sleep period
     */
    public void performTask() throws InterruptedException {
        // Simulating a task that takes approximately 500ms
        Thread.sleep(500);
    }

    /**
     * Simulates a quick operation that completes almost instantaneously.
     * <p>
     * This method is intended to demonstrate that a fast operation
     * easily passes a timeout assertion.
     * </p>
     *
     * @return the result of the quick computation
     */
    public int quickTask() {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += i;
        }
        return sum;
    }
}
