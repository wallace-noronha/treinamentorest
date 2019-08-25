package br.com.treinamento.restapi.controller;

import br.com.treinamento.restapi.model.Livro;
import br.com.treinamento.restapi.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class livrosController {

    @Autowired
    private LivrosRepository livrosRepository;

    @GetMapping()
    public List<Livro> listar(){
        return livrosRepository.findAll();
    }

    @PostMapping()
    public void salvar(@RequestBody Livro livro){
        livrosRepository.save(livro);
    }

    @GetMapping("/{id}")
    public Livro buscar(@PathVariable("id") Long id){
        return livrosRepository.findById(id).orElse(new Livro());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id) {
        livrosRepository.deleteById(id);
    }

}
