package com.josevabo.appfinancas.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.josevabo.appfinancas.model.DestinoLancamento} entity
 */
public class DestinoLancamentoDto implements Serializable {
    private final Long id;
    private final String nome;

    public DestinoLancamentoDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DestinoLancamentoDto entity = (DestinoLancamentoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nome, entity.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ")";
    }
}