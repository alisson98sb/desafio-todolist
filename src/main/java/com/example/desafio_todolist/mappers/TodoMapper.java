package com.example.desafio_todolist.mappers;

import com.example.desafio_todolist.dto.TodoPropertiesDTO;
import com.example.desafio_todolist.entity.Todo;

public class TodoMapper {
    public static TodoPropertiesDTO toDTO(Todo todo){
        return new TodoPropertiesDTO(
                todo.getId(),
                todo.getNome(),
                todo.getDescricao(),
                todo.isRealizado(),
                todo.getPrioridade()
        );
    }

    public static TodoPropertiesDTO toContentDTO(Todo todo) {
        return TodoMapper.toDTO(todo);
    }
}
