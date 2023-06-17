package com.josevabo.appfinancas.dto;

import com.josevabo.appfinancas.enums.TipoContaEnum;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.josevabo.appfinancas.model.Conta} entity
 */
public class ContaDto implements Serializable {
    private final Long id;
    private final String codigo;
    private final String apelido;
    private final InstituicaoFinanceiraDto instituicao;
    private final UsuarioDto usuario;
    private final TipoContaEnum tipoConta;
    private final Boolean afetaBalanco;

    public ContaDto(Long id, String codigo, String apelido, InstituicaoFinanceiraDto instituicao, UsuarioDto usuario, TipoContaEnum tipoConta, Boolean afetaBalanco) {
        this.id = id;
        this.codigo = codigo;
        this.apelido = apelido;
        this.instituicao = instituicao;
        this.usuario = usuario;
        this.tipoConta = tipoConta;
        this.afetaBalanco = afetaBalanco;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getApelido() {
        return apelido;
    }

    public InstituicaoFinanceiraDto getInstituicao() {
        return instituicao;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public  Boolean  getAfetaBalanco() {
        return afetaBalanco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaDto entity = (ContaDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.codigo, entity.codigo) &&
                Objects.equals(this.apelido, entity.apelido) &&
                Objects.equals(this.instituicao, entity.instituicao) &&
                Objects.equals(this.usuario, entity.usuario) &&
                Objects.equals(this.tipoConta, entity.tipoConta) &&
                Objects.equals(this.afetaBalanco, entity.afetaBalanco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, apelido, instituicao, usuario, tipoConta, afetaBalanco);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "codigo = " + codigo + ", " +
                "apelido = " + apelido + ", " +
                "instituicao = " + instituicao + ", " +
                "usuario = " + usuario + ", " +
                "tipoConta = " + tipoConta + ", " +
                "afetaBalanco = " + afetaBalanco + ")";
    }
}