package com.livraria.model;

public class Livro {
    // Variáveis para informações sobre o livro
    private int id;
    private String titulo;
    private String autor;
    private String categoria;
    private double preco;
    private String editora;
    private String isbn;

    // Construtor padrão (para criar objetos sem valor)
    public Livro() {
    }

    // Construtor com atributos (para criar objetos com valor)
    public Livro(int id, String titulo, String autor, String categoria, double preco, String editora, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.preco = preco;
        this.editora = editora;
        this.isbn = isbn;
    }

    // Getters e Setters das variáveis
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // toString para verificar os valores do objeto mais tarde
    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", categoria=" + categoria + ", preco=" + preco + ", editora=" + editora + ", isbn=" + isbn + "]";
    }
}
