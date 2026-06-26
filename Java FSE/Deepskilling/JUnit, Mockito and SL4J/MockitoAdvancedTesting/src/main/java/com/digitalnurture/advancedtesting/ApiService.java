package com.digitalnurture.advancedtesting;

/**
 * Service class that interfaces with external HTTP endpoints using a RestClient.
 */
public class ApiService {
    private final RestClient restClient;

    /**
     * Constructs ApiService with the provided RestClient dependency.
     *
     * @param restClient the restClient dependency to use
     */
    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }

    /**
     * Fetches raw responses from the external client and prefixes them.
     *
     * @return the fetched data string
     */
    public String fetchData() {
        return "Fetched " + restClient.getResponse();
    }
}
