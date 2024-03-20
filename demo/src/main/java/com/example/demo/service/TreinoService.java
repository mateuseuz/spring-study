package com.example.demo.service;

import com.example.demo.model.Treino;
import com.example.demo.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    public List<Treino> listarTreinos() {
        return treinoRepository.findAll();
    }

    public Treino criarTreino(Treino treino) {
        return treinoRepository.save(treino);
    }

    public Treino atualizarTreino(Treino treino, Long id) {
        if (treinoRepository.existsById(id)) {
            treino.setId(id);
            return treinoRepository.save(treino);
        }
        return null;
    }

    public boolean deletarTreino(Long id) {
        if (treinoRepository.existsById(id)) {
            treinoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int qtdTreinos() {
        return treinoRepository.findAll().size();
    }

    public Optional<Treino> buscarTreino(Long id) {
        return treinoRepository.findById(id);
    }
}
