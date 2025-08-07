package com.example.Zoomanager.enums.tarefa;

public enum StatusTarefaEnum {
    ABERTA("Aberta"),
    EXECUTANDO("Executando"),
    ENCERRADA("Encerrada");

    private final String descricao;

    StatusTarefaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
