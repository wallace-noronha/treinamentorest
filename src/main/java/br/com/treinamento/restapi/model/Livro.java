package br.com.treinamento.restapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

public class Livro {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String nome;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date publicacao;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String editora;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String resumo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Comentarios> comentarios;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String autor;

    public Livro(String nome) {
        this.nome = nome;
    }

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

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
