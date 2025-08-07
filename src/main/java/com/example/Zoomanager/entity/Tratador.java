package com.example.Zoomanager.entity;


import jakarta.persistence.*;

@Table(name = "Tratador")
@Entity
public class Tratador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean ocupado;


    public Tratador(Long id, String name, boolean ocupado) {
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

    public boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
