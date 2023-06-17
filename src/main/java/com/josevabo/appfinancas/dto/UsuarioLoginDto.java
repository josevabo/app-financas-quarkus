package com.josevabo.appfinancas.dto;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link Usuario} entity
 */
public class UsuarioLoginDto implements Serializable {
    @NotNull
    private final String nome;
    @NotNull
    private final String senha;

    public UsuarioLoginDto(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}