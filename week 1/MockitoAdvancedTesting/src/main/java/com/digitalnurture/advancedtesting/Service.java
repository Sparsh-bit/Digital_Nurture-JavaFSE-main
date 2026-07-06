package com.digitalnurture.advancedtesting;

/**
 * Service class that performs business logic using a Repository dependency.
 */
public class Service {
    private final Repository repository;

    /**
     * Constructs Service with the provided Repository dependency.
     *
     * @param repository the repository dependency to use
     */
    public Service(Repository repository) {
        this.repository = repository;
    }

    /**
     * Processes data fetched from the repository by prefixing it.
     *
     * @return the processed data string
     */
    public String processData() {
        return "Processed " + repository.getData();
    }
}
