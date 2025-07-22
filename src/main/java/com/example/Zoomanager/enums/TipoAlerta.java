package com.example.Zoomanager.enums;

public enum TipoAlerta {
    ALIMENTACAO("Alimentação");

    private final String descricao;

    TipoAlerta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
