package com.josevabo.appfinancas.dto;

import com.josevabo.appfinancas.model.CategoriaLancamento;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.josevabo.appfinancas.model.CategoriaLancamento} entity
 */
public class CategoriaLancamentoDto implements Serializable {
    private final Long id;
    private final String nome;
    private final CategoriaLancamentoDto categoriaParent;
    private final String descricao;

    public CategoriaLancamentoDto(Long id, String nome, CategoriaLancamentoDto categoriaParent, String descricao) {
        this.id = id;
        this.nome = nome;
        this.categoriaParent = categoriaParent;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaLancamentoDto getCategoriaParent() {
        return categoriaParent;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaLancamentoDto entity = (CategoriaLancamentoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.categoriaParent, entity.categoriaParent) &&
                Objects.equals(this.descricao, entity.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, categoriaParent, descricao);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ", " +
                "categoriaParent = " + categoriaParent + ", " +
                "descricao = " + descricao + ")";
    }
}