package com.example.Zoomanager.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long idEspecie;
    private LocalTime LastTimeFed;

    public Animal() {}

    public Animal(String name, Long idEspecie, LocalTime lastTimeFed) {
        this.name = name;
        this.idEspecie = idEspecie;
        LastTimeFed = lastTimeFed;
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

