package com.example.Zoomanager.entity;


import jakarta.persistence.*;


@Table(name=" TB HABITAT")
@Entity

public class Habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Habitat(Long id) {
        this.id = id;
    }
}
