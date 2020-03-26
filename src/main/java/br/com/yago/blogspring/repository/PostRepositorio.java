package br.com.yago.blogspring.repository;

import br.com.yago.blogspring.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepositorio extends JpaRepository<Post, Long> {
}
