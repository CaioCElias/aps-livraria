package com.livraria;

import com.livraria.controller.MainController;
import com.livraria.dao.*;
import com.livraria.view.*;

public class Main {
    static ConnectionDAO dao = new ConnectionDAO();
    static MainView view = new MainView();
    static MainController controller = new MainController(view);

    public static void main(String[] args) {
        view.startMainView();
        dao.openDatabase();
    }

}
