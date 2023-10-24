package com.livraria;

import com.livraria.dao.ConnectionDAO;
import com.livraria.view.MainView;

public class Main {
    static ConnectionDAO connection = new ConnectionDAO();
    static MainView view = new MainView();

    public static void main(String[] args) {
        view.startMainView();

        connection.getConnection();
    }
}