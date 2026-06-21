package com.digitalnurture.testing;

/**
 * Service class that depends on an ExternalApi.
 * Demonstrates dependency injection for testability with Mockito.
 */
public class MyService {

    private final ExternalApi externalApi;

    /**
     * Constructs MyService with the given ExternalApi dependency.
     *
     * @param externalApi the external API to use
     */
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    /**
     * Fetches data from the external API.
     *
     * @return the data retrieved from the external API
     */
    public String fetchData() {
        return externalApi.getData();
    }

    /**
     * Fetches data from the external API using a specific key.
     *
     * @param key the lookup key
     * @return the data retrieved from the external API
     */
    public String fetchData(String key) {
        return externalApi.getData(key);
    }

    /**
     * Processes data by delegating to the external API.
     *
     * @param data the data to process
     */
    public void processData(String data) {
        externalApi.processData(data);
    }
}
