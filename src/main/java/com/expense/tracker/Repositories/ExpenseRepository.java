
package com.expense.tracker.Repositories; // Declares the package this file belongs to

import com.expense.tracker.Models.Expense; // Imports the Expense entity class
import org.springframework.data.repository.CrudRepository; // Imports the CrudRepository interface from Spring Data

import java.util.List; // Imports the List interface from the Java Collections framework

// Defines a repository interface for Expense entities, extending CrudRepository to provide CRUD operations
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    List<Expense> findByUserId(Long userId); // Declares a method to find a list of Expense entities by userId

    List<Expense> findByCategoryId(Long categoryId); // Declares a method to find a list of Expense entities by categoryId
}