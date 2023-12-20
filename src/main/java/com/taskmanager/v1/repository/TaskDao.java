package com.taskmanager.v1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taskmanager.v1.entity.Task;

@Repository
public interface TaskDao extends CrudRepository<Task, Integer>{
    
}
