package com.livraria.controller;

import com.livraria.dao.AuthorDAO;
import com.livraria.dao.BookDAO;
import com.livraria.model.Authors;
import com.livraria.model.Books;
import com.livraria.view.BookView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class BookController implements ControllerInterface {
    BookDAO bookDao;
	BookView bookView;
	AuthorDAO authorDao;

	public BookController(BookDAO bookDao, BookView bookView, AuthorDAO authorDao) {
		this.bookDao = bookDao;
		this.bookView = bookView;
		this.authorDao = authorDao;
	}

	public void startController() {
		instanciateAuthorsList(authorDao);
		// Listener para o botão de adicionar livros
		bookView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					bookView.clearMessage();
					validateInputNotEmpty(bookView.getTitleInput(), bookView.getIsbnInput(),
							bookView.getPriceInput(), bookView.getPublisherInput());
					validateParseInt(bookView.getPublisherInput());
					validateParseDouble(bookView.getPriceInput());
					String title = bookView.getTitleInput();
					String isbn = bookView.getIsbnInput();
					int publisherId = Integer.parseInt(bookView.getPublisherInput());
					double price = Double.parseDouble(bookView.getPriceInput());
					Books book = new Books(title, isbn, publisherId, price);
					int[] selectedRows = bookView.getAuthorsTable().getSelectedRows();
					ArrayList<String> selectedAuthorsName = new ArrayList<>();
					ArrayList<String> selectedAuthorsSecondName = new ArrayList<>();
					for(int i : selectedRows) {
						String selectedAuthorName = bookView.getAuthorsTable().getValueAt(i, 0).toString();
						String selectedAuthorSecondName = bookView.getAuthorsTable()
								.getValueAt(i, 1).toString();
						selectedAuthorsName.add(selectedAuthorName);
						selectedAuthorsSecondName.add(selectedAuthorSecondName);
						System.out.println(selectedAuthorName);
					}
					boolean res = bookDao.addBooks(book, selectedAuthorsName, selectedAuthorsSecondName);
					if (res) {
						bookView.showMessage("Livro adicionado com sucesso");
					} else {
						bookView.showMessage("Não foi possível adicionar o livro");
					}
				} catch (SQLIntegrityConstraintViolationException e1) {
					bookView.showMessage("As informações inseridas estão incorretas");
					System.out.println("As informações inseridas estão incorretas");
				} catch (ValidationException ve) {
					System.out.println("Erro de validação: " + ve.getMessage());
				}
			}
		});
		// Listener para o botão de excluir livros
		bookView.delActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					bookView.clearMessage();
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
					bookView.showMessage("Não foi possível excluir o livro");
					System.out.println("Não foi possível excluir o livro");
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
					bookView.clearMessage();
					validateInputNotEmpty(bookView.getTitleInput(), bookView.getIsbnInput(),
							bookView.getPriceInput(), bookView.getPublisherInput());

				} catch (ValidationException ve) {
					System.out.println("Erro de validação: " + ve.getMessage());
				}
			}
		});
		// Listener para o botão de pesquisar livros
		bookView.searchActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					bookView.clearMessage();
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
	// Método que puxa os autores para inserir na respectiva lista na view de adicionar livros
	private void instanciateAuthorsList(AuthorDAO authorDao) {
		// Cria um DefaultListModel para armazenar os autores
		DefaultListModel<String> authorsListModel = new DefaultListModel<>();
		List<Authors> authors = authorDao.searchAuthors("%", "%");
		// Define as colunas da tabela
		String[] columnNames = {"Nome", "Sobrenome"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		// guarda as instâncias de autores em listModel e adiciona as instâncias na tabela
		for (Authors i : authors) {
			authorsListModel.addElement(i.getName() + " " + i.getFName());
			model.addRow(new Object[]{i.getName(), i.getFName()});
		}
		bookView.setTableModel(model);
		JList<String> authorsJList = new JList<String>(authorsListModel);
		bookView.setAuthorsList(authorsJList, model);
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
