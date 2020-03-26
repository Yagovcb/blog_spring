package br.com.yago.blogspring.repository;

import br.com.yago.blogspring.model.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncaoRepositorio extends JpaRepository<Funcao, Long> {

    Funcao findByUsuario(String usuario);
}
