package com.livraria.controller;

import com.livraria.dao.BookDAO;
import com.livraria.model.Books;
import com.livraria.view.BookView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
		// listener para o botão de adicionar livros
		bookView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = bookView.getTitleInput();
				String isbn = bookView.getIsbnInput();
				int publisher_id = Integer.parseInt(bookView.getPublisherInput());
				double price = Double.parseDouble(bookView.getPriceInput());
				
				Books book = new Books(title, isbn, publisher_id, price);

				try {
					boolean res = bookDao.addBooks(book);
					if(res) {
						bookView.showMessage("Livro adicionado com sucesso");
					} else {
						bookView.showMessage("Não foi possível adicionar o livro");
					}
				} catch (SQLIntegrityConstraintViolationException e1) {
					bookView.showMessage("Não foi possível adicionar o livro");
					e1.printStackTrace();
				}
			}
		});
		// listener para o botão de excluir livros
		bookView.delActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String isbn = bookView.getIsbnInput();
				System.out.println(isbn);
				try {
					boolean res1 = bookDao.deleteBooksAuthors(isbn);
					boolean res2 = bookDao.deleteBooks(isbn);
					if(res2) {
						bookView.showMessage("Livro excluído com sucesso");
					} else {
						bookView.showMessage("Não foi possível excluir o livro");
					}
				} catch (SQLIntegrityConstraintViolationException e1) {
					e1.printStackTrace();
				}
			}
		});
		// listener para o botão de modificar livros
		bookView.modifyActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botão funcionando");
			}
		});
		// listener para o botão de pesquisar livros
		bookView.searchActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = bookView.getTitleInput();
				List<Books> searchBookList = bookDao.searchBooksTitle(title);
				DefaultListModel listModel = new DefaultListModel();
				String[] columnNames = {"Título", "Editora", "Preço"};
				DefaultTableModel model = new DefaultTableModel(columnNames, 0);
				// guarda as instâncias de livros em listModel e adiciona as instâncias na tabela
				for(Books book : searchBookList) {
					listModel.addElement(book);
					model.addRow(new Object[]{book.getTitle(), book.getPublisherId(), book.getPrice()});
				}
				bookView.showSearchResult(model);
			}
		});
	}

}
