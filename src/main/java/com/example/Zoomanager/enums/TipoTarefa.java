package com.example.Zoomanager.enums;

public enum TipoTarefa {
    ALIMENTACAO("Alimentação");

    private final String descricao;

    TipoTarefa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
