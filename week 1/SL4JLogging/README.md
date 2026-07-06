# SLF4J and Logback Logging Exercises

This project contains clean, professional, and well-documented implementations and configuration profiles for the **SLF4J and Logback Logging** exercises as part of the Digital Nurture program.

---

## 📂 Project Directory Structure

```text
SLF4JLogging/
├── pom.xml
├── README.md
├── app.log (Generated automatically on run)
└── src
    └── main
        ├── java
        │   └── com
        │       └── digitalnurture
        │           └── logging
        │               ├── AppendersLoggingExample.java
        │               ├── LoggingExample.java
        │               └── ParameterizedLoggingExample.java
        └── resources
            └── logback.xml
```

---

## 🛠️ Technology Stack & Dependencies

The project leverages standard logging APIs to configure messaging appenders:
*   **Java Version**: 11 or higher
*   **SLF4J API**: `1.7.30` (A unified abstractions facade interface for various logging frameworks)
*   **Logback Classic**: `1.2.3` (An implementation native to SLF4J)

Dependencies are configured in [pom.xml](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/SL4JLogging/pom.xml).

---

## 📝 Exercise Implementations & Explanation

### Exercise 1: Logging Error Messages and Warning Levels
*   **Java Class**: [LoggingExample.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/SL4JLogging/src/main/java/com/digitalnurture/logging/LoggingExample.java)
*   **Concept**: Illustrates basic logger instantiation using `LoggerFactory.getLogger()` and printing logs at `ERROR` and `WARN` levels.

### Exercise 2: Parameterized Logging
*   **Java Class**: [ParameterizedLoggingExample.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/SL4JLogging/src/main/java/com/digitalnurture/logging/ParameterizedLoggingExample.java)
*   **Concept**: Illustrates placeholders-based string formatting `logger.info("User {} logged in...", username)` which avoids unnecessary string concatenation runtime computation when the targeted log level is disabled.

### Exercise 3: Using Different Appenders
*   **Config Profile**: [logback.xml](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/SL4JLogging/src/main/resources/logback.xml)
*   **Java Class**: [AppendersLoggingExample.java](file:///Volumes/Volume%20D/Digital-Nurture-JavaFSE-main/Java%20FSE/Deepskilling/JUnit,%20Mockito%20and%20SL4J/SL4JLogging/src/main/java/com/digitalnurture/logging/AppendersLoggingExample.java)
*   **Concept**: Configures two separate appender channels:
    1.  `ConsoleAppender`: Prints styled logs to standard system streams.
    2.  `FileAppender`: Writes logs locally into a file named `app.log`.
    The root level is set to `DEBUG`, feeding matching logs into both destinations.

---

## ⚡ How to Build & Run Demonstrations

To compile the application, navigate to the folder and build with Maven:

```bash
# Navigate to the project folder
cd "Java FSE/Deepskilling/JUnit, Mockito and SL4J/SL4JLogging"

# Build dependencies
mvn clean compile
```

To run individual examples via Java CLI, use the following commands:

```bash
# Run Exercise 1
mvn exec:java -Dexec.mainClass="com.digitalnurture.logging.LoggingExample"

# Run Exercise 2
mvn exec:java -Dexec.mainClass="com.digitalnurture.logging.ParameterizedLoggingExample"

# Run Exercise 3
mvn exec:java -Dexec.mainClass="com.digitalnurture.logging.AppendersLoggingExample"
```
