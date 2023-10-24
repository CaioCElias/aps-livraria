package com.livraria;

import com.livraria.dao.*;
import com.livraria.view.*;

public class Main {
    static ConexaoDAO dao = new ConexaoDAO();
    static LivroView view = new LivroView();

    public static void main(String[] args) {
        view.initializeView();
        dao.openDatabase();
        dao.closeDatabase();
    }

}
