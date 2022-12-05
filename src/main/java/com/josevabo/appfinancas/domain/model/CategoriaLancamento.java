package com.josevabo.appfinancas.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categoria", uniqueConstraints = {
        @UniqueConstraint(name = "uc_categoria_nome", columnNames = {"nome"})
})
public class CategoriaLancamento {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="parent_id")
    private CategoriaLancamento parent;

    private transient Set<CategoriaLancamento> subcategorias;

    public CategoriaLancamento() {
    }
}
