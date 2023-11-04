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

public class BookController implements ControllerInterface {
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
				try {
					validateInputNotEmpty(bookView.getTitleInput(), bookView.getIsbnInput(),
							bookView.getPriceInput(), bookView.getPublisherInput());
					validateParseInt(bookView.getPublisherInput());
					validateParseDouble(bookView.getPriceInput());
					String title = bookView.getTitleInput();
					String isbn = bookView.getIsbnInput();
					int publisherId = Integer.parseInt(bookView.getPublisherInput());
					double price = Double.parseDouble(bookView.getPriceInput());
					Books book = new Books(title, isbn, publisherId, price);
					boolean res = bookDao.addBooks(book);
					if (res) {
						bookView.showMessage("Livro adicionado com sucesso");
					} else {
						bookView.showMessage("Não foi possível adicionar o livro");
					}
				} catch (SQLIntegrityConstraintViolationException e1) {
					e1.printStackTrace();
				} catch (ValidationException ve) {
					System.out.println("Erro de validação: " + ve.getMessage());
				}
			}
		});
		// listener para o botão de excluir livros
		bookView.delActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					validateInputNotEmpty(bookView.getIsbnInput());
					String isbn = bookView.getIsbnInput();
					System.out.println(isbn);
					boolean res1 = bookDao.deleteBooksAuthors(isbn);
					boolean res2 = bookDao.deleteBooks(isbn);
					if (res2) {
						bookView.showMessage("Livro excluído com sucesso");
					} else {
						bookView.showMessage("Não foi possível excluir o livro");
					}
				} catch (SQLIntegrityConstraintViolationException e1) {
					e1.printStackTrace();
				} catch (ValidationException ve) {
					System.out.println("Erro de validação: " + ve.getMessage());
				}
			}
		});
		// Listener para o botão de modificar livros
		bookView.modifyActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botão funcionando");
				try {
					validateInputNotEmpty(bookView.getTitleInput(), bookView.getIsbnInput(),
							bookView.getPriceInput(), bookView.getPublisherInput());

				} catch (ValidationException ve) {
					System.out.println("Erro de validação: " + ve.getMessage());
				}
			}
		});
		// listener para o botão de pesquisar livros
		bookView.searchActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					validateInputNotEmpty(bookView.getTitleInput());
					String title = bookView.getTitleInput();
					validateSearchOutputNotEmpty(bookDao, title);
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
				} catch (ValidationException ve) {
					System.out.println("Erro de validação: " + ve.getMessage());
				}
			}
		});
	}
	// Validações
	// Verifica se algum elemento foi encontrado na busca
	private void validateSearchOutputNotEmpty(BookDAO bookDao, String title) throws ValidationException {
		try {
			bookDao.searchBooksTitle(title);
		} catch (IndexOutOfBoundsException ve) {
			bookView.showMessage("Nenhum livro encontrado");
			throw new ValidationException("Nenhum livro encontrado");
		}
	}
	// Verifica se o input não possui campos vazios
	private void validateInputNotEmpty(String... inputs) throws ValidationException {
		for(int i = 0; i < inputs.length; i++) {
			if(inputs[i].equals("")) {
				bookView.showMessage("Preencha todos os campos");
				throw new ValidationException("Preencha todos os campos");
			}
		}
	}
	// Verifica a possibilidade de um parseInt
	private void validateParseInt(String num) throws ValidationException {
		try {
			Integer.parseInt(num);
		} catch (NumberFormatException ve) {
			bookView.showMessage("Número inválido");
			throw new ValidationException("Número inválido");
		}
	}
	// Verifica a possibilidade de um parseInt
	private void validateParseDouble(String num) throws ValidationException {
		try {
			Double.parseDouble(num);
		} catch (NumberFormatException ve) {
			bookView.showMessage("Número inválido");
			throw new ValidationException("Número inválido");
		}
	}

	static class ValidationException extends Exception {
		public ValidationException(String message) {
			super(message);
		}
	}
}
