package br.com.yago.blogspring.service;

import br.com.yago.blogspring.model.Autor;

import java.util.List;

public interface AutorServico {

    List<Autor> findAll();
    Autor findById(long id);
    Autor cadastrar (Autor autor);
    Autor carregaAutorPeloEmail(String email) throws Exception;
}
