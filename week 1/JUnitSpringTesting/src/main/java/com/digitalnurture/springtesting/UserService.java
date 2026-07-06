package com.digitalnurture.springtesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

/**
 * Service class performing user management business actions.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Finds a user by ID. Throws NoSuchElementException if the user is missing.
     *
     * @param id user identifier
     * @return the User entity if found
     * @throws NoSuchElementException if user does not exist
     */
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    /**
     * Persists a new user record.
     *
     * @param user the user data entity to save
     * @return the saved user entity
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
