package com.josevabo.appfinancas.model;

import jakarta.persistence.*;

@Entity
@Table(name="instituicao")
public class InstituicaoFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @Enumerated(EnumType.ORDINAL)
    private TipoInstituicaoEnum tipo;

    public InstituicaoFinanceira() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoInstituicaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoInstituicaoEnum tipo) {
        this.tipo = tipo;
    }
}
