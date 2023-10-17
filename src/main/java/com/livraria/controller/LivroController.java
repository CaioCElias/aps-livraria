package com.livraria.controller;

import com.livraria.dao.LivroDAO;
import com.livraria.model.Livro;

import java.util.List;


public class LivroController {
    private LivroDAO livroDAO;

    public LivroController(LivroDAO livroDAO) {
        this.livroDAO = livroDAO;
    }

    // Método para adicionar um novo livro
    public boolean adicionarLivro(Livro livro) {
        // Implemente a lógica de validação, se necessário
        // Exemplo de validação simples: verifique se o título não é vazio.
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            return false;
        }

        return livroDAO.inserirLivro(livro);
    }

    // Método para listar todos os livros
    public List<Livro> listarLivros() {
        return livroDAO.listarLivros();
    }

    // Método para atualizar informações de um livro
    public boolean atualizarLivro(Livro livro) {
        // Implemente a lógica de validação, se necessário
        // Exemplo de validação simples: verifique se o livro tem um ID válido.
        if (livro.getId() <= 0) {
            return false;
        }

        return livroDAO.atualizarLivro(livro);
    }

    // Método para excluir um livro
    public boolean excluirLivro(int id) {
        // Implemente a lógica de validação, se necessário
        // Exemplo de validação simples: verifique se o ID é válido.
        if (id <= 0) {
            return false;
        }

        return livroDAO.excluirLivro(id);
    }

    // Certifique-se de tratar exceções apropriadas, se necessário
}
