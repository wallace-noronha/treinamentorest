package br.com.treinamento.restapi.repository;

import br.com.treinamento.restapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepository extends JpaRepository<Autor, Long> {
}
