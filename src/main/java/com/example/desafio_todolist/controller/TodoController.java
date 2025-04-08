package com.example.desafio_todolist.controller;

import com.example.desafio_todolist.entity.Todo;
import com.example.desafio_todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    List<Todo> list() {
        return todoService.list();
    }

    @GetMapping("/native")
    List<Todo> listByName(){return todoService.listNativeQuery(); }

    @PostMapping
    ResponseEntity<List<Todo>> create(@RequestBody Todo todo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body((todoService.create(todo)));
    }

    @PutMapping("{id}")
    List<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable Long id) {
        return todoService.delete(id);
    }
}
