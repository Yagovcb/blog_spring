package br.com.yago.blogspring.service.impl;

import br.com.yago.blogspring.model.Post;
import br.com.yago.blogspring.repository.PostRepositorio;
import br.com.yago.blogspring.service.PostServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostServicoImpl implements PostServico {

    @Autowired
    private PostRepositorio repositorio;

    @Override
    public List<Post> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Post findById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        post.setDataPostagem(LocalDate.now());
        return repositorio.save(post);
    }
}
