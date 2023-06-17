package com.josevabo.appfinancas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="categoria_lancamento")
public class CategoriaLancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @JoinColumn(name="id_categoria_parent")
    @ManyToOne
    private CategoriaLancamento categoriaParent;

    @OneToMany(fetch=FetchType.LAZY)
    @Transient
    private List<CategoriaLancamento> subCategorias;
    private String descricao;

    public CategoriaLancamento() {
    }

    public CategoriaLancamento(Long id) {
        this.id = id;
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

    public CategoriaLancamento getCategoriaParent() {
        return categoriaParent;
    }

    public void setCategoriaParent(CategoriaLancamento categoriaParent) {
        this.categoriaParent = categoriaParent;
    }

    public List<CategoriaLancamento> getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(List<CategoriaLancamento> subCategorias) {
        this.subCategorias = subCategorias;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
