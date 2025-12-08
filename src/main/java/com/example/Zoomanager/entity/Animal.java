package com.example.Zoomanager.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Table(name = "TB ANIMAL")
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "idEspecie", foreignKey = @ForeignKey(name = "animal_fk_especie"))
    private Especie especie;

    private LocalDateTime lastTimeFed;

    @ManyToOne
    @JoinColumn(name = "habitat_id")
    private Habitat habitat;

    public Animal() {}

    public Animal(String name, Especie especie, LocalDateTime lastTimeFed) {
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

    public LocalDateTime getLastTimeFed() {
        return lastTimeFed;
    }

    public void setLastTimeFed(LocalDateTime lastTimeFed) {
        this.lastTimeFed = lastTimeFed;
    }
}

