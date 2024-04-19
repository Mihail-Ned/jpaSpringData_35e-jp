package org.jpaspringdata.service;

import org.jpaspringdata.dto.AddToDoRequest;
import org.jpaspringdata.entity.ToDoEntity;
import org.jpaspringdata.repository.ToDoRepository;
import org.springframework.stereotype.Service;

@Service
public class AddToDoService {

    private ToDoRepository repository;

    public AddToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public ToDoEntity add(AddToDoRequest request) {
        System.out.println("Received request: " + request);
        var entityForAdd = convert(request);
        var createdEntity = repository.save(entityForAdd);
        System.out.println("Sending response: " + createdEntity);
        return createdEntity;
    }

    private ToDoEntity convert(AddToDoRequest request){
        ToDoEntity newEntity = new ToDoEntity();
        newEntity.setName(request.getName());
        newEntity.setDescription(request.getDescription());
        return newEntity;
    }
}
