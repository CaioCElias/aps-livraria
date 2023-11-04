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

	public void startController() {
		// listener para o botão de adicionar livros
		bookView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(verifyEmptyString(bookView.getTitleInput(), bookView.getIsbnInput(),
						bookView.getPriceInput(), bookView.getPublisherInput())) {
					String title = bookView.getTitleInput();
					String isbn = bookView.getIsbnInput();
					int publisherId = Integer.parseInt(bookView.getPublisherInput());
					double price = Double.parseDouble(bookView.getPriceInput());

					Books book = new Books(title, isbn, publisherId, price);

					try {
						boolean res = bookDao.addBooks(book);
						if (res) {
							bookView.showMessage("Livro adicionado com sucesso");
						} else {
							bookView.showMessage("Não foi possível adicionar o livro");
						}
					} catch (SQLIntegrityConstraintViolationException e1) {
						bookView.showMessage("Não foi possível adicionar o livro");
						e1.printStackTrace();
					}
				}
			}
		});
		// listener para o botão de excluir livros
		bookView.delActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(verifyEmptyString(bookView.getIsbnInput())) {
					String isbn = bookView.getIsbnInput();
					System.out.println(isbn);
					try {
						boolean res1 = bookDao.deleteBooksAuthors(isbn);
						boolean res2 = bookDao.deleteBooks(isbn);
						if (res2) {
							bookView.showMessage("Livro excluído com sucesso");
						} else {
							bookView.showMessage("Não foi possível excluir o livro");
						}
					} catch (SQLIntegrityConstraintViolationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		// Listener para o botão de modificar livros
		bookView.modifyActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botão funcionando");
				if(verifyEmptyString(bookView.getTitleInput(), bookView.getIsbnInput(),
						bookView.getPriceInput(), bookView.getPublisherInput())) {

				}
			}
		});
		// listener para o botão de pesquisar livros
		bookView.searchActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(verifyEmptyString(bookView.getTitleInput())) {
					String title = bookView.getTitleInput();
					List<Books> searchBookList = bookDao.searchBooksTitle(title);
					DefaultListModel listModel = new DefaultListModel();
					// Define as colunas da tabela
					String[] columnNames = {"Título", "Editora", "Preço"};
					DefaultTableModel model = new DefaultTableModel(columnNames, 0);
					// guarda as instâncias de livros em listModel e adiciona as instâncias na tabela
					for (Books book : searchBookList) {
						listModel.addElement(book);
						model.addRow(new Object[]{book.getTitle(), book.getPublisherId(), book.getPrice()});
					}
					bookView.showSearchResult(model);
				}
			}
		});
	}
	// Verifica se o input não possui campos vazios
	private boolean verifyEmptyString(String... inputs) {
		for(int i = 0; i < inputs.length; i++) {
			if(inputs[i].equals("")) {
				bookView.showMessage("Preencha todos os campos");
				return false;
			}
		}
		System.out.println("No empty strings");
		return true;
	}
}
