package org.jpaspringdata.repository;


import org.jpaspringdata.entity.ToDoEntity;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {
    ToDoEntity save(ToDoEntity entity);

    List<ToDoEntity> findAll();

    Optional<ToDoEntity> findById(Integer id);

}
