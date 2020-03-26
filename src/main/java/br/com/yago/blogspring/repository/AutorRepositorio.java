package br.com.yago.blogspring.repository;

import br.com.yago.blogspring.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {
    Autor findByEmail(String email);
    Autor findByNomeCompleto(String nomeCompleto);
}
