package com.livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe para conectar com o banco de dados
public class LivroDAO {
    private static String USER = "root";
    private static String PASS = "";
    private static String DATABASE = "veterinario22";
    private static String URL = "jdbc:mysql://localhost:3306/" + DATABASE;

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
}
