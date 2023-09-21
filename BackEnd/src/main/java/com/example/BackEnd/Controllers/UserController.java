package com.example.BackEnd.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackEnd.Entities.User;
import com.example.BackEnd.Services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService services;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return services.saveUser(user);
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Long id) {
        return services.getUser(id);
    }

    @GetMapping("/getAll")
    public List<User> getUsers() {
        return services.getUsers();
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        return services.deleteAll();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        boolean success = services.authenticateUser(user.getUsername(), user.getPassword());

        if (success) {
            response.put("success", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
