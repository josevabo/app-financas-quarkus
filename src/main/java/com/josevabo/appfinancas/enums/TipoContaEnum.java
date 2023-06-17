package com.josevabo.appfinancas.enums;

public enum TipoContaEnum {
    CONTA_CORRENTE("Conta corrente"),
    CARTAO_CREDITO("Cartão de crédito"),
    CARTEIRA("Carteira"),
    CONTA_BENEFICIO("Conta benefício");

    public final String label;

    TipoContaEnum(String label) {
        this.label = label;
    }
}
