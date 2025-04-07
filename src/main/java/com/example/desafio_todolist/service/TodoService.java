package com.example.desafio_todolist.service;

import com.example.desafio_todolist.entity.Todo;
import com.example.desafio_todolist.repository.TodoRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> list() {
        return todoRepository.findAll();
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> update(Long id, Todo todo) {
        todoRepository.findById(id).ifPresentOrElse((existingTodo) -> {
            todo.setId(id);
            todoRepository.save(todo);
        }, () -> {
            try {
                throw new BadRequestException("Todo %d não existe! ".formatted(id));
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        });

        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.findById(id).ifPresentOrElse((existingTodo)-> todoRepository.delete(existingTodo), () -> {
            try {
                throw new BadRequestException("Todo %d não existe! ".formatted(id));
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        });

        return list();
    }
}
