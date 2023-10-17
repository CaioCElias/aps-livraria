package com.livraria.dao;

// Escolher entre ConexaoDAO ou LivroDAO

import java.sql.*;

import javax.swing.plaf.nimbus.State;

// Classe para conectar com o banco de dados
public class ConexaoDAO {
    private static String URL = "jdbc:mysql://localhost:3306/pessoas";
    private static String USER = "root";
    private static String PASS = "";

    private Connection dbconn = null;
    private Statement sqlmgr = null;
    private ResultSet resultsql = null;

    public void OpenDatabase() {
        try {
            dbconn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado em" + URL);
            sqlmgr = dbconn.createStatement();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public void CloseDatabase() throws SQLException {
        sqlmgr.close();
        dbconn.close();
    }

    public int ExecutaQuery(String sql) {
        try {
            return sqlmgr.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        return -1;
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
