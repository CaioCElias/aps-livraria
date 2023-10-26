package com.livraria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.livraria.dao.BookDAO;
import com.livraria.view.BookView;

public class BookController {
    BookDAO dao;
	BookView view;

	public BookController(BookDAO dao, BookView view) {
		this.dao = dao;
		this.view = view;

	}

}
