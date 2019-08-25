package br.com.treinamento.restapi.repository;

import br.com.treinamento.restapi.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
