package com.example.Zoomanager.dto.tarefaDTO;

public class TarefaSaveDTO {
    private Long idTratador;
    private Long idAnimal;
    private String tipo;

    public TarefaSaveDTO() {}

    public TarefaSaveDTO(Long idTratador, Long idAnimal, String tipo) {
        this.idTratador = idTratador;
        this.idAnimal = idAnimal;
        this.tipo = tipo;
    }

    public Long getIdTratador() {
        return idTratador;
    }

    public void setIdTratador(Long idTratador) {
        this.idTratador = idTratador;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}