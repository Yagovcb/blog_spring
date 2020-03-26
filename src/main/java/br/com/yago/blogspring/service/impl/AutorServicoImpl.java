package br.com.yago.blogspring.service.impl;

import br.com.yago.blogspring.model.Autor;
import br.com.yago.blogspring.model.AutorUserDetail;
import br.com.yago.blogspring.repository.AutorRepositorio;
import br.com.yago.blogspring.service.AutorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AutorServicoImpl implements AutorServico, UserDetailsService {

    @Autowired
    private AutorRepositorio repositorio;

    @Override
    public List<Autor> findAll() { return repositorio.findAll(); }

    @Override
    public Autor findById(long id) { return repositorio.findById(id).get();  }

    @Override
    public Autor cadastrar(Autor autor) {
        return null;
    }

    @Override
    public Autor carregaAutorPeloEmail(String email) throws Exception{
        Autor autor = repositorio.findByEmail(email);
        if (Objects.isNull(autor)){
            throw new Exception("Não existe usuario cadastrado com esse email! " + email);
        }
        return autor;
    }


    @Override
    public UserDetails loadUserByUsername(String nomeCompleto) throws UsernameNotFoundException {

        Autor autor = repositorio.findByNomeCompleto(nomeCompleto);
        if (Objects.isNull(autor)){
            throw new UsernameNotFoundException("Usuario não existe!" + autor);
        }
        return new AutorUserDetail(autor);
    }
}
