package com.expense.tracker.Repositories; // Declares the package this file belongs to

import org.springframework.data.repository.CrudRepository; // Imports the CrudRepository interface from Spring Data

import com.expense.tracker.Models.User; // Imports the User entity class

import java.util.Optional;

// Defines a repository interface for User entities, extending CrudRepository to provide CRUD operations
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User>findByUsername(String username); // Declares a method to find a User by their username
}
