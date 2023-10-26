package com.livraria.controller;

import com.livraria.dao.BookDAO;
import com.livraria.view.BookView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookController {
    BookDAO dao;
	BookView bookView;

	public BookController(BookDAO dao, BookView bookView) {
		this.dao = dao;
		this.bookView = bookView;

		bookView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		bookView.delActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		bookView.modifyActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		bookView.searchActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dao.searchBooksByName("the");
			}
		});
	}

}
