package com.example.Zoomanager.dto.animalDTO;

import java.time.LocalDateTime;

public class AnimalSaveDTO {
    private String name;
    private Long idEspecie;
    private LocalDateTime lastTimeFed;

    public AnimalSaveDTO(){

    }

    public AnimalSaveDTO(String name, Long idEspecie, LocalDateTime lastTimeFed) {
        this.name = name;
        this.idEspecie = idEspecie;
        this.lastTimeFed = lastTimeFed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Long idEspecie) {
        this.idEspecie = idEspecie;
    }

    public LocalDateTime getLastTimeFed() {
        return lastTimeFed;
    }

    public void setLastTimeFed(LocalDateTime lastTimeFed) {
        this.lastTimeFed = lastTimeFed;
    }
}
