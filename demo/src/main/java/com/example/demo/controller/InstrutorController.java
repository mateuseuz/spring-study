package com.example.demo.controller;

import com.example.demo.model.Instrutor;
import com.example.demo.service.InstrutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    InstrutorService instrutorService;

    @GetMapping
    public List<Instrutor> listarInstrutores() {
        return instrutorService.listarInstrutores();
    }

    @PostMapping
    public Instrutor criar(@Valid @RequestBody Instrutor instrutor) {
        return instrutorService.criarInstrutor(instrutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Instrutor instrutor, @PathVariable Long id) {
        if(instrutorService.atualizarInstrutor(instrutor, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(instrutor);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(instrutorService.deletarInstrutor(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtdInstrutores() {
        return instrutorService.qtdInstrutores();
    }

    @GetMapping("/{id}")
    public Optional<Instrutor> buscarPorID(@PathVariable Long id) {
        return instrutorService.buscarInstrutor(id);
    }
}
