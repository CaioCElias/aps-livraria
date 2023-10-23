package com.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.livraria.model.Livro;

public class LivroDAO {
    private Connection dbconn;

    public LivroDAO(Connection connection) {
        this.dbconn = connection;
    }

    public boolean inserirLivro(Livro livro) {
        String sql = "INSERT INTO Books (title, isbn, publisher_id, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = dbconn.prepareStatement(sql)) {
            statement.setString(1, livro.getTitulo());
            statement.setString(2, livro.getIsbn());
            statement.setInt(3, livro.getEditoraId());
            statement.setDouble(4, livro.getPreco());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM Books";
        try (PreparedStatement statement = dbconn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setTitulo(resultSet.getString("title"));
                livro.setIsbn(resultSet.getString("isbn"));
                livro.setEditoraId(resultSet.getInt("publisher_id"));
                livro.setPreco(resultSet.getDouble("price"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }

    public boolean atualizarLivro(Livro livro) {
        String sql = "UPDATE Books SET title = ?, publisher_id = ?, price = ? WHERE isbn = ?";
        try (PreparedStatement statement = dbconn.prepareStatement(sql)) {
            statement.setString(1, livro.getTitulo());
            statement.setInt(2, livro.getEditoraId());
            statement.setDouble(3, livro.getPreco());
            statement.setString(4, livro.getIsbn());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean excluirLivro(String isbn) {
        String sql = "DELETE FROM Books WHERE isbn = ?";
        try (PreparedStatement statement = dbconn.prepareStatement(sql)) {
            statement.setString(1, isbn);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
