package br.com.treinamento.restapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Livro {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome é obrigatório")
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Publicação é obrigatório")
    private Date publicacao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "Editora é obrigatório")
    private String editora;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotEmpty(message = "Resumo é obrigatório")
    @Size(max = 1500, message = "Resumo não pode conter mais de 1500 caractéres.")
    private String resumo;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "livro")
    private List<Comentario> comentarios;

    @ManyToOne
    @JoinColumn(name = "AUTOR_ID")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Autor autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Date publicacao) {
        this.publicacao = publicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
