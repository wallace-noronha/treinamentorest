package br.com.treinamento.restapi.services;

import br.com.treinamento.restapi.model.Comentario;
import br.com.treinamento.restapi.model.Livro;
import br.com.treinamento.restapi.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ComentariosService {

    @Autowired
    private LivrosService livrosService;

    @Autowired
    private ComentarioRepository comentariosRepository;

    public Comentario salvar(Long livroId, Comentario comentario){
        Livro livro = livrosService.buscar(livroId);
        comentario.setLivro(livro);
        comentario.setData(new Date());

        return comentariosRepository.save(comentario);
    }


}
