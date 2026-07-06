package com.digitalnurture.springtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

/**
 * Exercise 7: Test Custom Repository Query
 *
 * Task: Add and test a custom query method.
 */
@DataJpaTest
@DisplayName("Exercise 7: Test Custom Repository Query")
public class Exercise7_UserRepositoryJpaTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Should successfully find list of users by custom findByName query method")
    public void testFindByName() {
        // Arrange
        User user1 = new User(1L, "David");
        User user2 = new User(2L, "David");
        User user3 = new User(3L, "Emma");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        // Act
        List<User> results = userRepository.findByName("David");

        // Assert
        assertEquals(2, results.size());
        results.forEach(user -> assertEquals("David", user.getName()));
    }
}
