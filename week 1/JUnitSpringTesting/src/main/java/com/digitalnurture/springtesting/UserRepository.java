package com.digitalnurture.springtesting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * UserRepository interface providing JpaRepository operations on User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Custom query method to find users by their name.
     * Used in Exercise 7.
     *
     * @param name name to filter by
     * @return list of matching User entities
     */
    List<User> findByName(String name);
}
