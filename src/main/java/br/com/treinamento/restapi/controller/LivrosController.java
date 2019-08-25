package br.com.treinamento.restapi.controller;

import br.com.treinamento.restapi.model.Comentario;
import br.com.treinamento.restapi.model.Livro;
import br.com.treinamento.restapi.services.ComentariosService;
import br.com.treinamento.restapi.services.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    private LivrosService livrosService;

    @Autowired
    private ComentariosService comentariosService;

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
        livro = livrosService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        livrosService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody Livro livro, @PathVariable("id") Long id){
        livro.setId(id);
        livrosService.atualizar(livro);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/comentarios")
    public ResponseEntity<Void> adicionarComentario(@PathVariable("id") Long id,@RequestBody Comentario comentario){
        comentariosService.salvar(id, comentario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}/comentarios")
    public ResponseEntity<List<Comentario>> listarComentarios(@PathVariable("id") Long livroId){
        List<Comentario> comentarioLivro = comentariosService.listarComentario(livroId);
        return ResponseEntity.status(HttpStatus.OK).body(comentarioLivro);
    }

}
