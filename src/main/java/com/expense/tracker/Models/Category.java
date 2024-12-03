package com.expense.tracker.Models; // Declares the package this file belongs to

import jakarta.persistence.*; // Imports JPA annotations and classes

@Entity // Marks this class as a JPA entity, meaning it will be mapped to a database table
@Table(name = "categories") // Specifies the table name in the database for this entity
public class Category {

    @Id // Marks 'id' as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the primary key generation strategy as IDENTITY (database will handle ID generation)
    private Long id;

    @Column(nullable = false, length = 100) // Maps this field to a column in the database, specifies that it cannot be null, and sets the maximum length to 100 characters
    private String name;

    @ManyToOne // Specifies a many-to-one relationship with another entity
    @JoinColumn(name = "user_id", nullable = false) // Specifies the foreign key column and that it cannot be null
    private User user;

    // Getter method to retrieve the category ID
    public Long getId() {
        return id;
    }

    // Setter method to update the category ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter method to retrieve the category name
    public String getName() {
        return name;
    }

    // Setter method to update the category name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method to retrieve the associated user
    public User getUser() {
        return user;
    }

    // Setter method to update the associated user
    public void setUser(User user) {
        this.user = user;
    }
}
