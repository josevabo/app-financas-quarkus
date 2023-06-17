package com.josevabo.appfinancas.dto;

import com.josevabo.appfinancas.model.InstituicaoFinanceira;
import com.josevabo.appfinancas.model.TipoInstituicaoEnum;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link InstituicaoFinanceira} entity
 */
public class InstituicaoFinanceiraDto implements Serializable {
    private final Long id;
    private final String nome;
    private final String descricao;
    private final TipoInstituicaoEnum tipo;

    public InstituicaoFinanceiraDto(Long id, String nome, String descricao, TipoInstituicaoEnum tipo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoInstituicaoEnum getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstituicaoFinanceiraDto entity = (InstituicaoFinanceiraDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.descricao, entity.descricao) &&
                Objects.equals(this.tipo, entity.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, tipo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ", " +
                "descricao = " + descricao + ", " +
                "tipo = " + tipo + ")";
    }
}