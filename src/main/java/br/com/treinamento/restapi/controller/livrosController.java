package br.com.treinamento.restapi.controller;

import br.com.treinamento.restapi.model.Livro;
import br.com.treinamento.restapi.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class livrosController {

    @Autowired
    private LivrosRepository livrosRepository;

    @GetMapping()
    public ResponseEntity<List<Livro>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(livrosRepository.findAll());
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody Livro livro){
        livro = livrosRepository.save(livro);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(livro.getId());

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        Livro livro = livrosRepository.findById(id).orElse(new Livro());

        if (livro.getNome() == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {

        try{
            livrosRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody Livro livro, @PathVariable("id") Long id){
        livro.setId(id);
        livrosRepository.save(livro);
        return ResponseEntity.noContent().build();
    }

}
