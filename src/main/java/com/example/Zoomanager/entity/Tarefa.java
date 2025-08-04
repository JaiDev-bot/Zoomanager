package com.example.Zoomanager.entity;

import com.example.Zoomanager.enums.tarefa.StatusTarefaEnum;
import com.example.Zoomanager.enums.tarefa.TipoTarefaEnum;

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

    @Enumerated(EnumType.STRING)
    private StatusTarefaEnum status;
    
    @Enumerated(EnumType.STRING)
    private TipoTarefaEnum tipo;

    public Tarefa() {}

    public Tarefa(Long idTratador, Animal animal, StatusTarefaEnum status, TipoTarefaEnum tipo) {
        this.idTratador = idTratador;
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

