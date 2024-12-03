
package com.expense.tracker.Repositories; // Declares the package this file belongs to

import org.springframework.data.repository.CrudRepository; // Imports the CrudRepository interface from Spring Data

import java.util.List; // Imports the List interface from the Java Collections framework

// Defines a repository interface for Category entities, extending CrudRepository to provide CRUD operations
public interface CategoryRepository extends CrudRepository<CategoryRepository, Long> {
    List<CategoryRepository> findByUserId(Long userId); // Declares a method to find a list of Category entities by userId
}
