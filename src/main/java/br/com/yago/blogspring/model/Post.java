package br.com.yago.blogspring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "post")
@Getter @Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    @NotBlank
    private String titulo;

//    @NotBlank
//    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id_autor")
    @Column(name = "autor")
    @NotBlank
    private String autor;

    @Column(name = "data_postagem")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataPostagem;

    @Column(name = "texto")
    @NotBlank
    @Lob
    private String texto;
}
