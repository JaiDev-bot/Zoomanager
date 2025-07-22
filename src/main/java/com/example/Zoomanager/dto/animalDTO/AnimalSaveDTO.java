package com.example.Zoomanager.dto.animalDTO;

import java.time.LocalTime;

public class AnimalSaveDTO {
    private String name;
    private Long idEspecie;
    private LocalTime lastTimeFed;

    public AnimalSaveDTO(String name, Long idEspecie, LocalTime lastTimeFed) {
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

    public LocalTime getLastTimeFed() {
        return lastTimeFed;
    }

    public void setLastTimeFed(LocalTime lastTimeFed) {
        this.lastTimeFed = lastTimeFed;
    }
}
