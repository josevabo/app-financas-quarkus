package com.josevabo.appfinancas.model;

import com.josevabo.appfinancas.enums.TipoContaEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String apelido;
    @JoinColumn(name = "id_instituicao")
    @ManyToOne
    private InstituicaoFinanceira instituicao;
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "id_tipo_conta")
    private TipoContaEnum tipoConta;

    @Column(name = "afeta_balanco")
    private boolean afetaBalanco;

    @OneToMany(fetch = FetchType.LAZY)
    @Transient
    private List<Lancamento> lancamentos;

    public Conta() {
    }

    public Conta(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public InstituicaoFinanceira getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(InstituicaoFinanceira instituicao) {
        this.instituicao = instituicao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    public boolean isAfetaBalanco() {
        return afetaBalanco;
    }

    public void setAfetaBalanco(boolean afetaBalanco) {
        this.afetaBalanco = afetaBalanco;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
}
