package org.example.controller;


import lombok.AllArgsConstructor;
import org.example.model.TodoRequest;
import org.example.model.TodoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        System.out.println("CREATE");

        if (ObjectUtils.isEmpty(request.getTitle()))
            return ResponseEntity.badRequest().build();

        return null;
    }

    @GetMapping("{id")
    public ResponseEntity<TodoResponse> readOne() {
        System.out.println("READ ONE");
        return null;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        System.out.println("READ ALL");
        return null;
    }

    @PatchMapping
    public ResponseEntity<TodoResponse> update() {
        System.out.println("UPDATE");
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne() {
        System.out.println("DELETE");
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        System.out.println("DELETE ALL");
        return null;
    }



}
