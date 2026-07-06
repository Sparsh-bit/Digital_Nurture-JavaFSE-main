package com.digitalnurture.advancedtesting;

/**
 * Interface representing a Database Repository.
 * Simulates persistence layer methods for fetching data.
 */
public interface Repository {
    /**
     * Fetches data from the database.
     *
     * @return the data string from the database
     */
    String getData();
}
