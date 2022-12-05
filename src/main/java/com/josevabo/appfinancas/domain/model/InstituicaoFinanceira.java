package com.josevabo.appfinancas.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "intituicao_financeira",
    uniqueConstraints = {
            @UniqueConstraint(columnNames = {"codigo"}),
            @UniqueConstraint(columnNames = {"nome"})
    }
)
public class InstituicaoFinanceira {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nome;
}
