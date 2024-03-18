package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "aluno_id")
public class Aluno extends Pessoa {
    private int matricula;
    private int idade;
    private double peso;
    private int altura;

    public Aluno() {
    }

    public Aluno(String nome, String cpf, int matricula, int idade, double peso, int altura) {
        super(nome, cpf);
        this.matricula = matricula;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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
