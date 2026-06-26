package com.digitalnurture.advancedtesting;

/**
 * Service class performing networking actions using NetworkClient dependency.
 */
public class NetworkService {
    private final NetworkClient networkClient;

    /**
     * Constructs NetworkService with the given NetworkClient dependency.
     *
     * @param networkClient the network client dependency
     */
    public NetworkService(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    /**
     * Connects to a server and prefixes the response message.
     *
     * @return connection confirmation message
     */
    public String connectToServer() {
        return "Connected to " + networkClient.connect();
    }
}
