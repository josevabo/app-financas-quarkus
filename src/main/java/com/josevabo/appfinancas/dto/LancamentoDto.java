package com.josevabo.appfinancas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.josevabo.appfinancas.model.CategoriaLancamento;

import java.math.BigDecimal;
import java.util.Date;

public class LancamentoDto {
    private Long id;
    private BigDecimal  valor;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date data;

    private String descricao;
    private CategoriaLancamentoDto categoria;
    private LancamentoDto lancamentoAnterior;
    private ContaDto conta;
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private Date tsCriacao;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaLancamentoDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaLancamentoDto categoria) {
        this.categoria = categoria;
    }

    public LancamentoDto getLancamentoAnterior() {
        return lancamentoAnterior;
    }

    public void setLancamentoAnterior(LancamentoDto lancamentoAnterior) {
        this.lancamentoAnterior = lancamentoAnterior;
    }

    public ContaDto getConta() {
        return conta;
    }

    public void setConta(ContaDto conta) {
        this.conta = conta;
    }
}
