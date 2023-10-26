package com.livraria;

import com.livraria.controller.BookController;
import com.livraria.controller.MainController;
import com.livraria.dao.*;
import com.livraria.view.*;

public class Main {
    //dao
    static ConnectionDAO dao = new ConnectionDAO();
    static BookDAO bookDAO = new BookDAO();
    //views
    static MainView view = new MainView();
    static BookView bookView = new BookView();
    static AuthorView authorView = new AuthorView();
    static PublisherView publisherView = new PublisherView();
    //controllers
    static MainController controller = new MainController(view, bookView, authorView, publisherView);
    static BookController bookController = new BookController(bookDAO, bookView);

    public static void main(String[] args) {
        view.startMainView();
        dao.openDatabase();
    }

}
