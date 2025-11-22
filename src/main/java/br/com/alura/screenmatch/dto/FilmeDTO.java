package br.com.alura.screenmatch.dto;

import br.com.alura.screenmatch.model.Filme;

public class FilmeDTO {

    private Long id;
    private String titulo;
    private Integer ano;
    private String diretor;
    private String genero;

    public FilmeDTO() {}

    public FilmeDTO(Filme filme) {
        this.id = filme.getId();
        this.titulo = filme.getTitulo();
        this.ano = filme.getAno();
        this.diretor = filme.getDiretor();
        this.genero = filme.getGenero();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public String getDiretor() { return diretor; }
    public void setDiretor(String diretor) { this.diretor = diretor; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    @Override
    public String toString() {
        return "FilmeDTO{id=" + id + ", titulo='" + titulo + "', ano=" + ano + 
               ", diretor='" + diretor + "', genero='" + genero + "'}";
    }
}
