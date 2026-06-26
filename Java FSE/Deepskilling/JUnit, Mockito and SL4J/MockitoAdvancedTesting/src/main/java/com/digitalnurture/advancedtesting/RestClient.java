package com.digitalnurture.advancedtesting;

/**
 * Interface representing a REST Client.
 * Simulates external API calls to fetch data.
 */
public interface RestClient {
    /**
     * Executes a remote GET request and fetches a response.
     *
     * @return the response payload as a string
     */
    String getResponse();
}
