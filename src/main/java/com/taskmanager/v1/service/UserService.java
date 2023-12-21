package com.taskmanager.v1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.v1.entity.User;
import com.taskmanager.v1.exception.UserNotFoundException;
// import com.taskmanager.v1.repository.TaskDao;
import com.taskmanager.v1.repository.UserDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    // @Autowired
    // private TaskDao taskDao;

    public User createNewUser(String firstName, String lastName, String email, String userName, String password) {
        User user = new User(firstName, lastName, email, userName, password);
        user.setId(0);

        userDao.save(user);

        return user;
    }

    // public User getUser(int id) {
    // return userDao.findById(id).get();
    // }

    public User getUser(int id) {
        Optional<User> user = userDao.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        return user.get();
    }

}
