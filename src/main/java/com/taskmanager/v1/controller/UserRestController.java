package com.taskmanager.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.v1.entity.User;
import com.taskmanager.v1.exception.UserErrorResponse;
import com.taskmanager.v1.exception.UserNotFoundException;
import com.taskmanager.v1.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return null;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
            return this.userService.getUser(id);
    }

    @PostMapping("/new")
    public User createUser(@RequestBody User entity) {
        User newUser = this.userService.createNewUser(entity.getFirstName(), entity.getLastName(), entity.getEmail(),
                entity.getUserName(), entity.getPassword());
        return newUser;
    }

    @DeleteMapping("/")
    public User deleteUser(@RequestBody User entity) {
        // TODO: process DELETE request
        return entity;
    }

    @PutMapping("/")
    public User updatUser(@RequestBody User entity) {
        // TODO: process PUT request

        return entity;
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException e) {
        UserErrorResponse error = new UserErrorResponse(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(404).body(error);
    }

}
