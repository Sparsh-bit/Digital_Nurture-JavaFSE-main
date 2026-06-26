package com.digitalnurture.dependenciestesting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository handling persistence layer operations on User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
