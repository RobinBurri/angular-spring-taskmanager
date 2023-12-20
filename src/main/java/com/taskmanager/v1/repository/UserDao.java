package com.taskmanager.v1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taskmanager.v1.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer>{
    
}
