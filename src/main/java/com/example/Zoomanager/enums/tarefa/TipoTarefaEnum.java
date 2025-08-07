package com.example.Zoomanager.enums.tarefa;

public enum TipoTarefaEnum {
    ALIMENTACAO("Alimentação");

    private final String descricao;

    TipoTarefaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
