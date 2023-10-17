package com.livraria.dao;

// Escolher entre ConexaoDAO ou LivroDAO

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.nimbus.State;

import com.livraria.model.Livro;

// Classe para conectar com o banco de dados
public class LivroDAO {
    private Connection conexao;

    public LivroDAO() {
        try {
            String DATABASE = "banco_de_dados";
            String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
            String USER = "root";
            String PASS = "";
            
            conexao = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean inserirLivro(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor, categoria, preco, editora, isbn) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getCategoria());
            stmt.setDouble(4, livro.getPreco());
            stmt.setString(5, livro.getEditora());
            stmt.setString(6, livro.getIsbn());

            int rowsAfetadas = stmt.executeUpdate();
            return rowsAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Livro livro = new Livro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("categoria"),
                    rs.getDouble("preco"),
                    rs.getString("editora"),
                    rs.getString("isbn")
                );
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }

    public boolean atualizarLivro(Livro livro) {
        String sql = "UPDATE livros SET titulo=?, autor=?, categoria=?, preco=?, editora=?, isbn=? WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getCategoria());
            stmt.setDouble(4, livro.getPreco());
            stmt.setString(5, livro.getEditora());
            stmt.setString(6, livro.getIsbn());
            stmt.setInt(7, livro.getId());

            int rowsAfetadas = stmt.executeUpdate();
            return rowsAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluirLivro(int id) {
        String sql = "DELETE FROM livros WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int rowsAfetadas = stmt.executeUpdate();
            return rowsAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Fecha a conexão quando não estiver mais em uso.
    public void fecharConexao() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

/*
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }

    public static void testaConnection() {
        try (Connection c = getConnection()) {
            System.out.println("Conexão estabelecida");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
}
