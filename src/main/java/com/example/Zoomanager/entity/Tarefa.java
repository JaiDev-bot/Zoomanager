package com.example.Zoomanager.entity;

import com.example.Zoomanager.enums.TipoTarefa;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idTratador; // TODO: Mudar para Tratador quando a entidade for criada e adicionar o relacionamento

    @ManyToOne
    @JoinColumn(name = "idAnimal", referencedColumnName = "id")
    private Animal animal;

    private boolean aberto;

    @Enumerated(EnumType.STRING)
    private TipoTarefa tipo;

    public Tarefa() {}

    public Tarefa(Long idTratador, Animal animal, boolean aberto, TipoTarefa tipo) {
        this.idTratador = idTratador;
        this.animal = animal;
        this.aberto = aberto;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public long setId(long id) {
        this.id = id;
        return id;
    }

    public Long getIdTratador() {
        return idTratador;
    }

    public void setIdTratador(Long idTratador) {
        this.idTratador = idTratador;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public TipoTarefa getTipo() {
        return tipo;
    }

    public void setTipo(TipoTarefa tipo) {
        this.tipo = tipo;
    }
}

