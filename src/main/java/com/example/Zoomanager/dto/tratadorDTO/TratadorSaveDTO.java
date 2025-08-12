package com.example.Zoomanager.dto.tratadorDTO;

import com.example.Zoomanager.entity.Tratador;

public class TratadorSaveDTO {
    private Long id;
    private String name;
    private Boolean ocupado;

    public TratadorSaveDTO(){

    }


    public TratadorSaveDTO(Tratador tratador) {
        this.id = tratador.getId();
        this.name = tratador.getName();
        this.ocupado = tratador.getOcupado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }
}





