package com.example.demo.controller;

import com.example.demo.model.Instrutor;
import com.example.demo.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {
    @Autowired
    InstrutorRepository instrutorRepository;

    @GetMapping
    public List<Instrutor> listarInstrutores() {
        return instrutorRepository.findAll();
    }

    @PostMapping
    public Instrutor criar (@RequestBody Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }
}