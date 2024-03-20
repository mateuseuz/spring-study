package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "aluno_id")
public class Aluno extends Pessoa {
    @NotNull
    @Size(min = 13, max = 120)
    @Column(nullable = false)
    private int idade;

    @NotNull
    @Column(nullable = false)
    private double peso;

    @NotNull
    @Size(min = 150, max = 215)
    @Column(nullable = false)
    private int altura;

    public Aluno() {
    }

    public Aluno(String nome, String cpf, int idade, double peso, int altura) {
        super(nome, cpf);
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
