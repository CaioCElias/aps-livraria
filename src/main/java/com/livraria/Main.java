package com.livraria;

import com.livraria.controller.AuthorController;
import com.livraria.controller.BookController;
import com.livraria.controller.MainController;
import com.livraria.controller.PublisherController;
import com.livraria.dao.*;
import com.livraria.view.*;

public class Main {
    //dao
    static ConnectionDAO dao = new ConnectionDAO();
    static BookDAO bookDAO = new BookDAO();
    static AuthorDAO authorDao = new AuthorDAO();
    static PublisherDAO publisherDao = new PublisherDAO();
    //views
    static MainView view = new MainView();
    static BookView bookView = new BookView();
    static AuthorView authorView = new AuthorView();
    static PublisherView publisherView = new PublisherView();
    //controllers
    static MainController controller = new MainController(view, bookView, authorView, publisherView);
    static BookController bookController = new BookController(bookDAO, bookView);
    static AuthorController authorController = new AuthorController(authorDao, authorView);
    static PublisherController publisherController = new PublisherController(publisherDao, publisherView);

    public static void main(String[] args) {
        view.startMainView();
        controller.startMainController();
        bookController.startController();
        authorController.startController();
        publisherController.startController();
        dao.openDatabase();
        //dao.closeDatabase();
    }

}
