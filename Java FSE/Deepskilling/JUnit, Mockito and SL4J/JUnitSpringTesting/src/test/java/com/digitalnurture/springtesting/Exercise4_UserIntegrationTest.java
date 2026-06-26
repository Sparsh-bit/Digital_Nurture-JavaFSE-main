package com.digitalnurture.springtesting;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Exercise 4: Integration Test with Spring Boot
 *
 * Task: Write an integration test that tests the full flow from controller to database.
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Exercise 4: Integration Test with Spring Boot")
public class Exercise4_UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("Should fetch saved User from database through HTTP GET end-to-end integration flow")
    public void testIntegrationFlow() throws Exception {
        // Arrange (Save directly to DB)
        User savedUser = userRepository.save(new User(100L, "Charlie"));

        // Act & Assert (Request via MockMvc Controller)
        mockMvc.perform(get("/users/{id}", 100L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(100))
                .andExpect(jsonPath("$.name").value("Charlie"));
    }
}
