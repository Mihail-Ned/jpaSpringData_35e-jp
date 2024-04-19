package org.jpaspringdata.controller;


import org.jpaspringdata.dto.AddToDoRequest;
import org.jpaspringdata.entity.ToDoEntity;
import org.jpaspringdata.service.AddToDoService;
import org.jpaspringdata.service.FindAllToDoService;
import org.jpaspringdata.service.FindToDoById;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final AddToDoService addToDoService;
    private final FindAllToDoService findAllToDoService;
    private final FindToDoById findToDoById;

    public ToDoController(AddToDoService addToDoService, FindAllToDoService findAllToDoService, FindToDoById findToDoById) {
        this.addToDoService = addToDoService;
        this.findAllToDoService = findAllToDoService;
        this.findToDoById = findToDoById;
    }

    @PostMapping
    public ToDoEntity add(@RequestBody AddToDoRequest request) {
        return addToDoService.add(request);
    }

    @GetMapping
    public List<ToDoEntity> findAll() {
        return findAllToDoService.findAll();
    }

    @GetMapping(value = "/{idPath}")
    public ToDoEntity findToDoById(@PathVariable("idPath") Integer id) {
        return findToDoById.findById(id);
    }
}

