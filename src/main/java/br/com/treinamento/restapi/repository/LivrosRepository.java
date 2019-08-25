package br.com.treinamento.restapi.repository;

import br.com.treinamento.restapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
