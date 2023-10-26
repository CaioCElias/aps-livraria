package com.livraria.controller;

import com.livraria.dao.BookDAO;
import com.livraria.view.BookView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookController {
    BookDAO bookDao;
	BookView bookView;

	public BookController(BookDAO bookDao, BookView bookView) {
		this.bookDao = bookDao;
		this.bookView = bookView;
	}

	public void startBookController() {
		bookView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botão funcionando");
			}
		});
		bookView.delActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botão funcionando");
			}
		});
		bookView.modifyActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botão funcionando");
			}
		});
		bookView.searchActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bookDao.searchBooksByName("the");
			}
		});
	}

}
