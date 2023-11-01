package com.livraria.controller;

import com.livraria.dao.BookDAO;
import com.livraria.model.Books;
import com.livraria.view.BookView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

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
				String title = bookView.getTitleInput();
				String isbn = bookView.getIsbnInput();
				int publisher_id = Integer.parseInt(bookView.getPublisherInput());
				double price = Double.parseDouble(bookView.getPriceInput());
				
				Books book = new Books(title, isbn, publisher_id, price);

				try {
					bookDao.addBooks(book);
				} catch (SQLIntegrityConstraintViolationException e1) {
					e1.printStackTrace();
				}
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
				String title = bookView.getTitleInput();
				List<Books> searchBookList = bookDao.searchBooksTitle(title);
				JList list = new JList((ListModel) searchBookList);
				//exibir searchBookList
				bookView.showBookList(list);
				//bookView.getDialog().setSize(750, 250);
				//bookView.getPanel().add(new JList((ListModel) searchBookList));
				//list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				//list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
				//list.setVisibleRowCount(-1);
				//JScrollPane listScroller = new JScrollPane(list);
				//listScroller.setPreferredSize(new Dimension(250, 80));
			}
		});
	}

}
