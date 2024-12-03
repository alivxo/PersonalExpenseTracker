package com.expense.tracker;

import com.expense.tracker.Models.User;
import com.expense.tracker.Repositories.UserRepository;
import org.apache.camel.language.bean.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackerApplication {

  public static void main(String[] args) {
    // This is the main method, the entry point of the Java application.
    // It starts the Spring Boot application by running the TrackerApplication class.
    SpringApplication.run(TrackerApplication.class, args);
  }

//  @Bean(ref = "testing-db-component")
//  public CommandLineRunner demo(UserRepository repository) {
//    // This method returns a CommandLineRunner bean, which will be executed after the application context is loaded.
//    return args -> {
//      // Save a new User object to the database with a null ID (assuming it's auto-generated), a name, and an email.
//      repository.save(new User(null, "example 1", "example@example.com"));
//      // Save another User object to the database.
//      repository.save(new User(null, "example 2", "example@example.com"));
//      // Save yet another User object to the database.
//      repository.save(new User(null, "example 3", "example@example.com"));
//
//      // Retrieve all User entities from the database and print each one to the console.
//      repository.findAll().forEach(System.out::println);
//    };
 // }
}
