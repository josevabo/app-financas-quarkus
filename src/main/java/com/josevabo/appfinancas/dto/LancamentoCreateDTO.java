package com.josevabo.appfinancas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.josevabo.appfinancas.model.Conta;
import com.josevabo.appfinancas.model.DestinoLancamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class LancamentoCreateDTO {
    private BigDecimal valor;
    private LocalDate data;
    private String descricao;
    private CategoriaLancamentoDto categoria;
    private LancamentoDto lancamentoAnterior;
    private ContaDto conta;
    private DestinoLancamentoDto destinoLancamento;

    public LancamentoCreateDTO() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaLancamentoDto getCategoria() {
        return categoria;
    }

    @JsonProperty("categoria")
    public void setCategoria(CategoriaLancamentoDto categoria) {
        if(Objects.isNull(categoria)) return;
        this.categoria = new CategoriaLancamentoDto(categoria.getId(), null, null, null);
    }

    public LancamentoDto getLancamentoAnterior() {
        return lancamentoAnterior;
    }

    @JsonProperty("lancamentoAnterior")
    public void setLancamentoAnteriorOnlyId(LancamentoDto lancamentoAnterior) {
        if(Objects.isNull(lancamentoAnterior)) return;
        LancamentoDto novo = new LancamentoDto();
        novo.setId(lancamentoAnterior.getId());
        this.lancamentoAnterior = novo;
    }

    public ContaDto getConta() {
        return conta;
    }

    @JsonProperty("conta")
    public void setContaOnlyId(ContaDto conta) {
        if(Objects.isNull(conta)) return;
        this.conta = new ContaDto(conta.getId(),null,null,null,null,null,null);
    }

    public DestinoLancamentoDto getDestinoLancamento() {
        return destinoLancamento;
    }

    @JsonProperty("destinoLancamento")
    public void setDestinoLancamentoOnlyId(DestinoLancamentoDto destinoLancamento) {
        if(Objects.isNull(destinoLancamento)) return;
        this.destinoLancamento = new DestinoLancamentoDto(destinoLancamento.getId(), null);
    }
}
