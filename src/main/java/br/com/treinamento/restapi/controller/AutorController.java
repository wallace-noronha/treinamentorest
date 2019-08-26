package br.com.treinamento.restapi.controller;

import br.com.treinamento.restapi.model.Autor;
import br.com.treinamento.restapi.services.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutoresService autoresService;

    @GetMapping
    private ResponseEntity<List<Autor>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(autoresService.listar());
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody Autor autor){
        autoresService.salvar(autor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscar(@PathVariable("id") Long id){
        Autor autor = autoresService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(autor);
    }

}
