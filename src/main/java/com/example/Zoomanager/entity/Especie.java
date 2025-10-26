package com.example.Zoomanager.entity;

import java.time.LocalTime;

import com.example.Zoomanager.enums.especie.TipoAlimentacaoEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Especie")
@Entity
public class Especie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TipoAlimentacaoEnum tipoAlimentacao;

    private String nome;

    private LocalTime horarioPrimeiraRefeicao;

    private LocalTime horarioSegundaRefeicao;

    private LocalTime horarioTerceiraRefeicao;

    public Especie() {}

    public Especie(TipoAlimentacaoEnum tipoAlimentacao, String nome, LocalTime horarioPrimeiraRefeicao, LocalTime horarioSegundaRefeicao, LocalTime horarioTerceiraRefeicao) {
        this.tipoAlimentacao = tipoAlimentacao;
        this.nome = nome;
        this.horarioPrimeiraRefeicao = horarioPrimeiraRefeicao;
        this.horarioSegundaRefeicao = horarioSegundaRefeicao;
        this.horarioTerceiraRefeicao = horarioTerceiraRefeicao;
    }

    public Long getId() {
        return id;
    }

    public long setId(long id) {
        this.id = id;
        return id;
    }

    public TipoAlimentacaoEnum getTipoAlimentacao() {
        return tipoAlimentacao;
    }

    public void setTipoAlimentacao(TipoAlimentacaoEnum tipoAlimentacao) {
        this.tipoAlimentacao = tipoAlimentacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalTime getHorarioPrimeiraRefeicao() {
        return horarioPrimeiraRefeicao;
    }

    public void setHorarioPrimeiraRefeicao(LocalTime horarioPrimeiraRefeicao) {
        this.horarioPrimeiraRefeicao = horarioPrimeiraRefeicao;
    }

    public LocalTime getHorarioSegundaRefeicao() {
        return horarioSegundaRefeicao;
    }

    public void setHorarioSegundaRefeicao(LocalTime horarioSegundaRefeicao) {
        this.horarioSegundaRefeicao = horarioSegundaRefeicao;
    }

    public LocalTime getHorarioTerceiraRefeicao() {
        return horarioTerceiraRefeicao;
    }

    public void setHorarioTerceiraRefeicao(LocalTime horarioTerceiraRefeicao) {
        this.horarioTerceiraRefeicao = horarioTerceiraRefeicao;
    }

}
