package com.josevabo.appfinancas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="lancamento")
public class Lancamento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="id_conta")
    @ManyToOne
    private Conta conta;
    private BigDecimal valor;
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private LocalDate data;
    @JoinColumn(name="id_categoria")
    @ManyToOne
    private CategoriaLancamento categoria;
    @Column(name="ts_criacao")
    private LocalDateTime tsCriacao;
    @JoinColumn(name="id_destino")
    @ManyToOne
    private DestinoLancamento destinoLancamento;
    private String descricao;

    @JoinColumn(name="id_lncmto_anterior")
    @ManyToOne
    private Lancamento lancamentoAnterior;

    public Lancamento() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public CategoriaLancamento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaLancamento categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getTsCriacao() {
        return tsCriacao;
    }

    public void setTsCriacao(LocalDateTime tsCriacao) {
        this.tsCriacao = tsCriacao;
    }

    public DestinoLancamento getDestinoLancamento() {
        return destinoLancamento;
    }

    public void setDestinoLancamento(DestinoLancamento destinoLancamento) {
        this.destinoLancamento = destinoLancamento;
    }

    public Lancamento getLancamentoAnterior() {
        return lancamentoAnterior;
    }

    public void setLancamentoAnterior(Lancamento lancamentoAnterior) {
        this.lancamentoAnterior = lancamentoAnterior;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
