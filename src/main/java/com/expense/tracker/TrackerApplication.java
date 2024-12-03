package com.expense.tracker;

import com.expense.tracker.Entities.User;
import com.expense.tracker.Repositories.UserRepository;
import org.apache.camel.language.bean.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackerApplication {

  public static void main(String[] args) {
    SpringApplication.run(TrackerApplication.class, args);
  }

  @Bean(ref = "testing-db-component")
  public CommandLineRunner demo(UserRepository repository) {
    return args -> {
      // save a couple of customers
      repository.save(new User(null, "example 1", "example@example.com"));
      repository.save(new User(null, "example 2", "example@example.com"));
      repository.save(new User(null, "example 3", "example@example.com"));

      repository.findAll().forEach(System.out::println);
    };
  }
}
