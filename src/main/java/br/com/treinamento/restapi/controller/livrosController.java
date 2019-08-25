package br.com.treinamento.restapi.controller;

import br.com.treinamento.restapi.model.Livro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class livrosController {

    @GetMapping("/livros")
    public List<Livro> listar(){

        Livro l1 = new Livro("Rest aplicado");

        Livro l2 = new Livro("Git passo-a-passo");

        Livro[] livros = {l1,l2};
        return Arrays.asList(livros);


    }

}
