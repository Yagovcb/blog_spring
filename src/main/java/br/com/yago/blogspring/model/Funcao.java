package br.com.yago.blogspring.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "funcao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcao implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "nome")
    private String nome;

    @Override
    public String getAuthority() {
        return this.nome;
    }
}
