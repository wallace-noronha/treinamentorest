package br.com.treinamento.restapi.controller;

import br.com.treinamento.restapi.model.Livro;
import br.com.treinamento.restapi.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class livrosController {

    @Autowired
    private LivrosRepository livrosRepository;

    @GetMapping("/livros")
    public List<Livro> listar(){

        return livrosRepository.findAll();

    }

}
