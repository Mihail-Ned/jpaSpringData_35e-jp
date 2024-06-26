package org.jpaspringdata.service;


import org.jpaspringdata.entity.ToDoEntity;
import org.jpaspringdata.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindAllToDoService {

    private final ToDoRepository repository;

    public FindAllToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public List<ToDoEntity> findAll(){
        List<ToDoEntity> entities = repository.findAll();
        List<String> errors = new ArrayList<>();

        if (entities.isEmpty()) {
            errors.add("Our database is empty");
        }

        return entities;
    }

}
