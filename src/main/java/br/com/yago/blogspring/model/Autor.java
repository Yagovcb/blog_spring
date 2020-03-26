package br.com.yago.blogspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "autor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "usuario")
    private String usuario;

    @NonNull
    @JsonIgnore
    @Column(name = "senha")
    private String senha;

    @NonNull
    @Column(name = "nome_completo")
    private String nomeCompleto;

    @NonNull
    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Funcao> funcoes;

    //---- Construtores modificados
    public Autor (String usuario, String email){
        super();
        this.email = email;
        this.usuario = usuario;
    }

    public Autor (Autor autor){
        super();
        this.id = autor.getId();
        this.usuario = autor.getUsuario();
        this.email = autor.getEmail();
        this.funcoes = autor.getFuncoes();
        this.nomeCompleto = autor.getNomeCompleto();
    }
}
