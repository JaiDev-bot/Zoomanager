package com.example.Zoomanager.enums.especie;

public enum TipoAlimentacaoEnum {

    HERBIVORO("Herbívoro"),
    CARNIVORO("Carnívoro"),
    ONIVORO("Onívoro");

    private final String descricao;

    TipoAlimentacaoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
