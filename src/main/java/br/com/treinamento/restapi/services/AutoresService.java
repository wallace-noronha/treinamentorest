package br.com.treinamento.restapi.services;

import br.com.treinamento.restapi.model.Autor;
import br.com.treinamento.restapi.repository.AutoresRepository;
import br.com.treinamento.restapi.services.exception.AutorExistenteException;
import br.com.treinamento.restapi.services.exception.AutorNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AutoresService {

    @Autowired
    private AutoresRepository autoresRepository;

    public List<Autor> listar(){
        return autoresRepository.findAll();
    }

    public Autor salvar(Autor autor){
        if(autor.getId() != null && autoresRepository.findById(autor.getId()).isPresent()){
            throw new AutorExistenteException("O autor " + autor.getNome() + " já existe");
        }
        return autoresRepository.save(autor);
    }


    public Autor buscar(Long id){
        return autoresRepository.findById(id).orElseThrow(()-> new AutorNaoEncontradoException("O autor não pode ser encontrado"));
    }

}
