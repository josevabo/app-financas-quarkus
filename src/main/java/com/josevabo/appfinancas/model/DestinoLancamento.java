package com.josevabo.appfinancas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="destino_lancamento")
public class DestinoLancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(fetch=FetchType.LAZY)
    private List<Lancamento> lancamentos;

    public DestinoLancamento() {
    }

    public DestinoLancamento(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
}
