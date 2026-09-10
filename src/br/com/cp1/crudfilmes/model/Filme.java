package br.com.cp1.crudfilmes.model;

public class Filme {

    private int id;
    private String titulo;
    private String diretor;
    private int anoLancamento;
    private String genero;

    public Filme() {
    }

    public Filme(String titulo, String diretor, int anoLancamento, String genero) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    public Filme(int id, String titulo, String diretor, int anoLancamento, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", diretor='" + diretor + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", genero='" + genero + '\'' +
                '}';
    }
}