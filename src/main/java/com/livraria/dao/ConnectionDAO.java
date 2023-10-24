package com.livraria.dao;

import java.sql.*;

public class ConnectionDAO {
    private static String database = "library";
    private static String url = "jdbc:mysql://localhost:3306/" + database;
    private static String user = "root";
    private static String pass = "root";

    public Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectado com sucesso ao Banco de Dados!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}