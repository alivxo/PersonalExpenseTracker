package com.expense.tracker.Models; // Declares the package this file belongs to

import jakarta.persistence.*; // Imports JPA annotations and classes
import java.time.LocalDate; // Imports the LocalDate class from the java.time package

@Entity // Marks this class as a JPA entity, meaning it will be mapped to a database table
@Table(name = "expenses") // Specifies the table name in the database for this entity
public class Expense {

    @Id // Marks 'id' as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the primary key generation strategy as IDENTITY (database will handle ID generation)
    private Long id;

    @Column(nullable = false) // Maps this field to a column in the database and specifies that it cannot be null
    private Double amount;

    @Column(length = 255) // Maps this field to a column in the database with a maximum length of 255 characters
    private String description;

    @Column(nullable = false) // Maps this field to a column in the database and specifies that it cannot be null
    private LocalDate date;

    @ManyToOne // Specifies a many-to-one relationship with another entity
    @JoinColumn(name = "user_id", nullable = false) // Specifies the foreign key column and that it cannot be null
    private User user;

    @ManyToOne // Specifies a many-to-one relationship with another entity
    @JoinColumn(name = "category_id", nullable = false) // Specifies the foreign key column and that it cannot be null
    private Category category;

    // Getter method to retrieve the expense ID
    public Long getId() {
        return id;
    }

    // Setter method to update the expense ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter method to retrieve the expense amount
    public Double getAmount() {
        return amount;
    }

    // Setter method to update the expense amount
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    // Getter method to retrieve the expense description
    public String getDescription() {
        return description;
    }

    // Setter method to update the expense description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter method to retrieve the expense date
    public LocalDate getDate() {
        return date;
    }

    // Setter method to update the expense date
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter method to retrieve the associated user
    public User getUser() {
        return user;
    }

    // Setter method to update the associated user
    public void setUser(User user) {
        this.user = user;
    }

    // Getter method to retrieve the associated category
    public Category getCategory() {
        return category;
    }

    // Setter method to update the associated category
    public void setCategory(Category category) {
        this.category = category;
    }
}