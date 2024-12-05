package com.expense.tracker.Service; // Declares the package this file belongs to

import com.expense.tracker.Models.User; // Imports the User entity class
import com.expense.tracker.Repositories.UserRepository; // Imports the UserRepository interface
import org.springframework.beans.factory.annotation.Autowired; // Imports the Autowired annotation from Spring
import org.springframework.security.crypto.password.PasswordEncoder; // Imports the PasswordEncoder interface from Spring Security
import org.springframework.stereotype.Service; // Imports the Service annotation from Spring

import java.util.Optional; // Imports the Optional class from the Java standard library

@Service // Indicates that this class is a Spring service component
public class UserService {

    @Autowired // Marks this field to be autowired by Spring's dependency injection
    private UserRepository userRepository;

    @Autowired
    UserEmailService userEmailService;

    @Autowired // Marks this field to be autowired by Spring's dependency injection
    private PasswordEncoder passwordEncoder;

    // Method to register a new user
    public User registerUser(User user) {
        // Encodes the user's password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User registeredUser = userRepository.save(user);
        userEmailService.sendRegistrationEmail(registeredUser);

        return registeredUser;
    }

    // Method to find a user by their username
    public Optional<User> findByUsername(String username) {
        // Retrieves a user entity by username from the database
        return userRepository.findByUsername(username);
    }
}
