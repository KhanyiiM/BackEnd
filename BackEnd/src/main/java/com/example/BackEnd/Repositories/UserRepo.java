package com.example.BackEnd.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackEnd.Entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

// Repository that will be extending our JapRepo to so that we can have the JPA
// functions that have our SQL commands.