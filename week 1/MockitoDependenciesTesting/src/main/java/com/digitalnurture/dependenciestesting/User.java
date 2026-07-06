package com.digitalnurture.dependenciestesting;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity representing a User.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;
    private String name;

    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
