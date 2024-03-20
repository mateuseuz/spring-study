package com.example.demo.service;

import com.example.demo.model.Aula;
import com.example.demo.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    public List<Aula> listarAulas() {
        return aulaRepository.findAll();
    }

    public Aula criarAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    public Aula atualizarAula(Aula aula, Long id) {
        if (aulaRepository.existsById(id)) {
            aula.setId(id);
            return aulaRepository.save(aula);
        }
        return null;
    }

    public boolean deletarAula(Long id) {
        if (aulaRepository.existsById(id)) {
            aulaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int qtdAulas() {
        return aulaRepository.findAll().size();
    }

    public Optional<Aula> buscarAula(Long id) {
        return aulaRepository.findById(id);
    }
}
