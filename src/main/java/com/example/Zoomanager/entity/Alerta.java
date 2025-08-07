package com.example.Zoomanager.entity;

import com.example.Zoomanager.enums.TipoAlerta;

import jakarta.persistence.*;


@Table(name = "Alerta")
@Entity
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idTratador; // TODO: Mudar para Tratador quando a entidade for criada e adicionar o relacionamento

    @ManyToOne
    @JoinColumn(name = "idAnimal", referencedColumnName = "id")
    private Animal animal;

    private boolean aberto;

    @Enumerated(EnumType.STRING)
    private TipoAlerta tipo;

    public Alerta() {}

    public Alerta(Long idTratador, Animal animal, boolean aberto, TipoAlerta tipo) {
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

    public TipoAlerta getTipo() {
        return tipo;
    }

    public void setTipo(TipoAlerta tipo) {
        this.tipo = tipo;
    }
}

