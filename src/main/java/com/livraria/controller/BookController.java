package com.livraria.controller;

import com.livraria.dao.BookDAO;
import com.livraria.view.BookView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookController {
    BookDAO dao;
	BookView view;

	public BookController(BookDAO dao, BookView view) {
		this.dao = dao;
		this.view = view;

		view.addBookSearchActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

}
