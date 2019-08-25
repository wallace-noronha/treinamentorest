package br.com.treinamento.restapi.services;

import br.com.treinamento.restapi.model.Autor;
import br.com.treinamento.restapi.repository.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoresService {

    @Autowired
    private AutoresRepository autoresRepository;

    public List<Autor> listar(){
        return autoresRepository.findAll();
    }

}
