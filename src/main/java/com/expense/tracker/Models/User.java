package com.expense.tracker.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Marks this class as a JPA entity, meaning it will be mapped to a database table
@Entity
public class User {

    // Marks 'id' as the primary key of the entity
    @Id
    // Configures the primary key generation strategy as AUTO (database will handle ID generation)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Represents the user's name column in the database
    private String name;

    // Represents the user's email column in the database
    private String email;

    // Represents the user's password column in the database
    private String password;

    // Default constructor required by JPA
    public User() {}

    // Parameterized constructor to create a User object with all fields
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getter method to retrieve the user's email
    public String getEmail() {
        return email;
    }

    // Setter method to update the user's email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter method to retrieve the user's name
    public String getName() {
        return name;
    }

    // Setter method to update the user's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method to retrieve the user's password
    public String getPassword() {
        return password;
    }

    // Setter method to update the user's password
    public void setPassword(String password) {
        this.password = password;
    }
}