package com.example.demo.service;

import com.example.demo.model.Instrutor;
import com.example.demo.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public List<Instrutor> listarInstrutores() {
        return instrutorRepository.findAll();
    }

    public Instrutor criarInstrutor(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    public Instrutor atualizarInstrutor(Instrutor instrutor, Long id) {
        if (instrutorRepository.existsById(id)) {
            instrutor.setId(id);
            return instrutorRepository.save(instrutor);
        }
        return null;
    }

    public boolean deletarInstrutor(Long id) {
        if (instrutorRepository.existsById(id)) {
            instrutorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int qtdInstrutores() {
        return instrutorRepository.findAll().size();
    }

    public Optional<Instrutor> buscarInstrutor(Long id) {
        return instrutorRepository.findById(id);
    }
}
