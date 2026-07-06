package com.digitalnurture.dependenciestesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class performing user management business logic.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves a user by their ID.
     * Returns null if user is not found.
     *
     * @param id user ID
     * @return the User entity, or null
     */
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
