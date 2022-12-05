package com.josevabo.appfinancas.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tipo_conta", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nome"}),
})
public class TipoConta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    public TipoConta() {
    }
}
