package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String horario;
    private String instrutorResponsavel;
    private int capacidadeMax;

    public Aula(String nome, String horario, String instrutorResponsavel, int capacidadeMax) {
        this.nome = nome;
        this.horario = horario;
        this.instrutorResponsavel = instrutorResponsavel;
        this.capacidadeMax = capacidadeMax;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getInstrutorResponsavel() {
        return instrutorResponsavel;
    }

    public void setInstrutorResponsavel(String instrutorResponsavel) {
        this.instrutorResponsavel = instrutorResponsavel;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }
}