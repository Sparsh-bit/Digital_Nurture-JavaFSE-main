package com.digitalnurture.testing;

/**
 * Represents an external API dependency.
 * This interface simulates an external service that provides data.
 * Used across Exercises 1-3 and 5-6 for mocking and stubbing demonstrations.
 */
public interface ExternalApi {

    /**
     * Retrieves data from the external source.
     *
     * @return the data string from the external API
     */
    String getData();

    /**
     * Retrieves data associated with a specific key.
     *
     * @param key the lookup key
     * @return the data string corresponding to the key
     */
    String getData(String key);

    /**
     * Processes and persists the given data.
     *
     * @param data the data to process
     */
    void processData(String data);
}
