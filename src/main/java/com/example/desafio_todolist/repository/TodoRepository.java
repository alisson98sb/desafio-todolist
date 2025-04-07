package com.example.desafio_todolist.repository;

import com.example.desafio_todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
