package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Instrutor extends Pessoa {
    private String especialidade;

    public Instrutor() {
    }

    public Instrutor(String nome, String cpf, String especialidade) {
        super(nome, cpf);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}