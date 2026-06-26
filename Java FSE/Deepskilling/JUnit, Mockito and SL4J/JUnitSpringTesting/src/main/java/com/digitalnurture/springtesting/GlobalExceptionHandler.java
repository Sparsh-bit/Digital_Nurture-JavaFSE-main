package com.digitalnurture.springtesting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.NoSuchElementException;

/**
 * Controller advice class mapping custom and standard exceptions to HTTP responses.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Intercepts NoSuchElementException and returns HTTP 404 NOT_FOUND status.
     *
     * @param ex the intercepted NoSuchElementException exception
     * @return response entity with string body and NOT_FOUND status
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
