package com.taskmanager.v1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.v1.entity.User;
import com.taskmanager.v1.exception.UserNotFoundException;
import com.taskmanager.v1.repository.UserDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;


    public User createNewUser(String firstName, String lastName, String email, String userName, String password) {
        User user = new User(firstName, lastName, email, userName, password);
        user.setId(0);

        userDao.save(user);

        return user;
    }

    public User updateUser(int id, String firstName, String lastName, String email, String userName, String password) {
        User user = getUser(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUserName(userName);
        user.setPassword(password);
        User updatedUser = userDao.save(user);
        return updatedUser;
    }

    public List<User> getAllUsers() {
        Iterable<User> users = userDao.findAll();
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            userList.add(user);
        }
        return userList;
    }

    public User getUser(int id) {
        Optional<User> user = userDao.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    public void deleteUser(int id) {
        userDao.deleteById(id);
    }

}
