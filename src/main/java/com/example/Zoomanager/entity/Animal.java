package com.example.Zoomanager.entity;

import java.time.LocalTime;

public class Animal {
    private String name;
    private Long idEspecie;
    private LocalTime LastTimeFed;

    public Animal(String name, Long idEspecie, LocalTime lastTimeFed) {
        this.name = name;
        this.idEspecie = idEspecie;
        LastTimeFed = lastTimeFed;
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
        return LastTimeFed;
    }

    public void setLastTimeFed(LocalTime lastTimeFed) {
        LastTimeFed = lastTimeFed;
    }
}

