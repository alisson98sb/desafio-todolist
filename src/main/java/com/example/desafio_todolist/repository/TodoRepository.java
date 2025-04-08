package com.example.desafio_todolist.repository;

import com.example.desafio_todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    //verifica se a ordem existe
    @Query("SELECT t FROM Todo t  WHERE t.nome = :nome")
    List<Todo> findByNome(@Param("nome") String nome);


}
