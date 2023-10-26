package com.livraria.dao;

import java.sql.*;

import javax.swing.plaf.nimbus.State;

// Classe para conectar com o banco de dados
public class ConnectionDAO {
    public static String DATABASE = "library"; // MUDAR O PUBLIC
    public static String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    public static String USER = "root";
    public static String PASS = "root";

    private Connection dbconn = null;
    private Statement sqlmgr = null;
    private ResultSet resultsql = null;

    public void openDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbconn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado em " + URL);
            sqlmgr = dbconn.createStatement();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public void closeDatabase() {
        try {
            if (sqlmgr != null) {
                sqlmgr.close();
            }
            if (dbconn != null) {
                dbconn.close();
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public int ExecutaQuery(String sql) {
        try {
            return sqlmgr.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        return -1;
    }
}
