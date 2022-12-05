package com.josevabo.appfinancas.domain.model;

import javax.persistence.*;

@Entity
@Table(name="tipo_conta", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nome"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class Conta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "instituicao_financeira_id")
    private InstituicaoFinanceira instituicaoFinanceira;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "tipo_conta_id")
    private TipoConta tipoConta;


    public Conta() {
    }
}
