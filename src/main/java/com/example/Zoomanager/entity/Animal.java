package com.example.Zoomanager.entity;

import java.time.LocalTime;

import jakarta.persistence.*;

@Table(name = "Animal")
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "idEspecie", foreignKey = @ForeignKey(name = "animal_fk_especie"))
    private Especie especie;

    private LocalTime lastTimeFed;

    public Animal() {}

    public Animal(String name, Especie especie, LocalTime lastTimeFed) {
        this.name = name;
        this.especie = especie;
        this.lastTimeFed = lastTimeFed;
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

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public LocalTime getLastTimeFed() {
        return lastTimeFed;
    }

    public void setLastTimeFed(LocalTime lastTimeFed) {
        this.lastTimeFed = lastTimeFed;
    }
}

