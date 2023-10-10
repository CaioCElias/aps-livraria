package com.livraria.dao;

// Classe para conectar e interagir com o banco de dados

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LivroDAO {
    private Connection conexao;

    public LivroDAO() {
        try {
            String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
            String usuario = "seu_usuario";
            String senha = "sua_senha";

            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
