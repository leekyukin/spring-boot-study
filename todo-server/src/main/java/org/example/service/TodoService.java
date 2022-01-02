package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoEntity add (TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitile(request.getTitile());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());
        return this.todoRepository.save(todoEntity);
    }

    public List<TodoEntity> searchById(Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    public TodoEntity updateById(Long id) {
        return null;
    }
    public void deleteById(Long id) {
    }



}
