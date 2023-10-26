package com.livraria;

import com.livraria.dao.*;
import com.livraria.view.*;

public class Main {
    static ConnectionDAO dao = new ConnectionDAO();
    static MainView view = new MainView();

    public static void main(String[] args) {
        view.startMainView();
        dao.openDatabase();
    }

}
