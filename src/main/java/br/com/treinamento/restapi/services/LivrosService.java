package br.com.treinamento.restapi.services;

import br.com.treinamento.restapi.model.Livro;
import br.com.treinamento.restapi.repository.LivrosRepository;
import br.com.treinamento.restapi.services.exception.LivroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    public List<Livro> listar(){
        return livrosRepository.findAll();
    }

    public Livro buscar(Long id){
        Livro livro = livrosRepository.findById(id).orElse(new Livro());

        if (livro.getNome() == null){
            throw new LivroNaoEncontradoException("Livro não pode ser encontrado");
        }
        return livro;
    }

    public Livro salvar(Livro livro){
        livro.setId(null);
        return livrosRepository.save(livro);
    }

    public void atualizar(Livro livro){
        verificarExistencia(livro);
        livrosRepository.save(livro);
    }

    public void deletar(Long id){
        try{
            livrosRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new LivroNaoEncontradoException("O livro não pode ser encontrado");
        }

    }

    private void verificarExistencia(Livro livro){
        buscar(livro.getId());
    }

}
