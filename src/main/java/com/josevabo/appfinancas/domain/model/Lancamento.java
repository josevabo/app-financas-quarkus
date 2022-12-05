package com.josevabo.appfinancas.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Lancamento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDateTime dataHora;
    private BigDecimal valor;
    @ManyToOne
    @JoinColumn(name="conta_id")
    private Conta conta;
    @ManyToOne
    @JoinColumn(name="categoria_id")
    private CategoriaLancamento categoria;
    @ManyToOne
    @JoinColumn(name="destino_id")
    private DestinoLancamento destino;

    public Lancamento() {
    }
}
