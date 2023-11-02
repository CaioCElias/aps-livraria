package com.livraria.controller;

import com.livraria.dao.BookDAO;
import com.livraria.model.Books;
import com.livraria.view.BookView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

class ArrayListModel<T> extends AbstractListModel<T> {
	private ArrayList<T> list;

	public ArrayListModel(ArrayList<T> list) {
		this.list = list;
	}

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public T getElementAt(int index) {
		return list.get(index);
	}
}

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
				DefaultListModel listModel = new DefaultListModel();
				for(Books book : searchBookList) {
					listModel.addElement(book);
				}
				JList list = new JList(listModel);

				String[] columnNames = {"Título", "Editora", "Preço"};
				DefaultTableModel model = new DefaultTableModel(columnNames, 0);
				for (Books book : searchBookList) {
					model.addRow(new Object[]{book.getTitle(), book.getPublisherId(), book.getPrice()});
				}
				JTable table = new JTable(model);
				bookView.showBookList(list, model);
			}
		});
	}

}
