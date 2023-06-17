package com.josevabo.appfinancas.dto;

import com.josevabo.appfinancas.model.Usuario;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Usuario} entity
 */
public class UsuarioDto implements Serializable {
    private final Long id;
    private final String nome;
    private final String nomeCompleto;
    private final String email;

    public UsuarioDto(Long id, String nome, String nomeCompleto, String email) {
        this.id = id;
        this.nome = nome;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDto entity = (UsuarioDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.nomeCompleto, entity.nomeCompleto) &&
                Objects.equals(this.email, entity.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nomeCompleto, email);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ", " +
                "nomeCompleto = " + nomeCompleto + ", " +
                "email = " + email + ")";
    }
}