package com.example.BackEnd.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackEnd.Entities.User;
import com.example.BackEnd.Repositories.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User getUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public String deleteAll() {
        repository.deleteAll();
        return "Data deleted";
    }

    public boolean authenticateUser(String username, String password) {
        User user = repository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}

// creating the functionality of the application using
// those functions from our JPA.