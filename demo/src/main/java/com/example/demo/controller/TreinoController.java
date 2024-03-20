package com.example.demo.controller;

import com.example.demo.model.Treino;
import com.example.demo.service.TreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treinos")
public class TreinoController {
    @Autowired
    TreinoService treinoService;

    @GetMapping
    public List<Treino> listarTreinos() {
        return treinoService.listarTreinos();
    }

    @PostMapping
    public Treino criar(@Valid @RequestBody Treino treino) {
        return treinoService.criarTreino(treino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Treino treino, @PathVariable Long id) {
        if(treinoService.atualizarTreino(treino, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(treino);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(treinoService.deletarTreino(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtdTreinos() {
        return treinoService.qtdTreinos();
    }

    @GetMapping("/{id}")
    public Optional<Treino> buscarPorID(@PathVariable Long id) {
        return treinoService.buscarTreino(id);
    }
}