package com.expense.tracker.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.expense.tracker.Entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
