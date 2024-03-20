package com.example.demo.controller;

import com.example.demo.model.Aula;
import com.example.demo.service.AulaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aulas")
public class AulaController {
    @Autowired
    AulaService aulaService;

    @GetMapping
    public List<Aula> listarAulas() {
        return aulaService.listarAulas();
    }

    @PostMapping
    public Aula criar(@Valid @RequestBody Aula aula) {
        return aulaService.criarAula(aula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Aula aula, @PathVariable Long id) {
        if(aulaService.atualizarAula(aula, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(aula);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(aulaService.deletarAula(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtdAulas() {
        return aulaService.qtdAulas();
    }

    @GetMapping("/{id}")
    public Optional<Aula> buscarPorID(@PathVariable Long id) {
        return aulaService.buscarAula(id);
    }
}