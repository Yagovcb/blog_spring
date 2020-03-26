package br.com.yago.blogspring.service;

import br.com.yago.blogspring.model.Post;
import java.util.List;

public interface PostServico {

    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);
}
