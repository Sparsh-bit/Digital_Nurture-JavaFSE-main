package com.digitalnurture.advancedtesting;

/**
 * Service class performing I/O operations using FileReader and FileWriter.
 */
public class FileService {
    private final FileReader fileReader;
    private final FileWriter fileWriter;

    /**
     * Constructs FileService with FileReader and FileWriter dependencies.
     *
     * @param fileReader the reader dependency
     * @param fileWriter the writer dependency
     */
    public FileService(FileReader fileReader, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    /**
     * Processes file by reading from reader, writing processed result to writer, and returning it.
     *
     * @return the processed content
     */
    public String processFile() {
        String data = fileReader.read();
        String processedData = "Processed " + data;
        fileWriter.write(processedData);
        return processedData;
    }
}
