package com.digitalnurture.advancedtesting;

/**
 * Interface representing a Network Client connection utility.
 */
public interface NetworkClient {
    /**
     * Connects to a remote server.
     *
     * @return the status/identifier of the connection
     */
    String connect();
}
