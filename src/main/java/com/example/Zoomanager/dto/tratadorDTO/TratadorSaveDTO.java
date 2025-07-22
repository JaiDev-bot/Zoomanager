package com.example.Zoomanager.dto.tratadorDTO;

public class TratadorSaveDTO {
    private Long id;
    private String name;
    private Boolean ocupado;

    public TratadorSaveDTO(){

    }


    public TratadorSaveDTO(Long id, String name, Boolean ocupado) {
        this.id = id;
        this.name = name;
        this.ocupado = ocupado;
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





