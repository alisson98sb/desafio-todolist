package com.example.desafio_todolist.dto;

public record TodoPropertiesDTO(
        Long id,
        String nome,
        String descricao,
        boolean realizado,
        int prioridade
) {
}
