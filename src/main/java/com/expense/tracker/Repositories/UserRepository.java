package com.expense.tracker.Repositories; // Declares the package this file belongs to

import org.springframework.data.repository.CrudRepository; // Imports the CrudRepository interface from Spring Data

import com.expense.tracker.Entities.User; // Imports the User entity class

// Defines a repository interface for User entities, extending CrudRepository to provide CRUD operations
public interface UserRepository extends CrudRepository<User, Long> {
}
