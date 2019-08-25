package br.com.treinamento.restapi.controller;

import br.com.treinamento.restapi.model.Livro;
import br.com.treinamento.restapi.repository.LivrosRepository;
import br.com.treinamento.restapi.services.LivrosService;
import br.com.treinamento.restapi.services.exception.LivroNaoEncontradoException;
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
    private LivrosService livrosService;

    @GetMapping()
    public ResponseEntity<List<Livro>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(livrosService.listar());
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody Livro livro){
        livro = livrosService.salvar(livro);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(livro.getId());

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id){
        Livro livro;
        try {
            livro = livrosService.buscar(id);
        }catch (LivroNaoEncontradoException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        try{
            livrosService.deletar(id);
        } catch (LivroNaoEncontradoException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody Livro livro, @PathVariable("id") Long id){
        livro.setId(id);
        try {
            livrosService.atualizar(livro);
        } catch (LivroNaoEncontradoException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
