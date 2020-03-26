package br.com.yago.blogspring.controle;

import br.com.yago.blogspring.model.Autor;
import br.com.yago.blogspring.model.Funcao;
import br.com.yago.blogspring.model.enums.FuncaoEnum;
import br.com.yago.blogspring.repository.AutorRepositorio;
import br.com.yago.blogspring.service.AutorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutorControle {

    @Autowired
    private AutorServico servico;

    @Autowired
    private AutorRepositorio repositorio;

    @Secured({"ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<Autor> save(@RequestBody Autor autor){
        autor = this.repositorio.save(autor);
        return new ResponseEntity<Autor>(autor, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
   @PutMapping
    public ResponseEntity<Autor> edit(@RequestBody Autor autor){
        autor = this.repositorio.save(autor);
        return new ResponseEntity<Autor>(autor, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN","ROLE_CLIENT"})
    @GetMapping
    public ResponseEntity<Page<Autor>> list(  @RequestParam("page") int page,  @RequestParam("size") int size ){
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        return new ResponseEntity<Page<Autor>>(repositorio.findAll(pageable), HttpStatus.OK);
    }
}
