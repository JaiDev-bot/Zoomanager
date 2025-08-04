package com.example.Zoomanager.entity;

import com.example.Zoomanager.enums.tarefa.StatusTarefaEnum;
import com.example.Zoomanager.enums.tarefa.TipoTarefaEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
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

    @ManyToOne
    @JoinColumn(name = "idTratador", foreignKey = @ForeignKey(name = "tarefa_fk_tratador"))
    private Tratador tratador;
    
    @ManyToOne
    @JoinColumn(name = "idAnimal", foreignKey = @ForeignKey(name = "tarefa_fk_animal"))
    private Animal animal;

    @Enumerated(EnumType.STRING)
    private StatusTarefaEnum status;
    
    @Enumerated(EnumType.STRING)
    private TipoTarefaEnum tipo;

    public Tarefa() {}

    public Tarefa(Tratador tratador, Animal animal, StatusTarefaEnum status, TipoTarefaEnum tipo) {
        this.tratador = tratador;
        this.animal = animal;
        this.status = status;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public long setId(long id) {
        this.id = id;
        return id;
    }

    public Tratador getTratador() {
        return tratador;
    }

    public void setTratador(Tratador tratador) {
        this.tratador = tratador;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public StatusTarefaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusTarefaEnum status) {
        this.status = status;
    }

    public TipoTarefaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTarefaEnum tipo) {
        this.tipo = tipo;
    }
}

