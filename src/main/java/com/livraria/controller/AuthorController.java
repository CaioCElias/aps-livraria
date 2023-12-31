package com.livraria.controller;

import com.livraria.dao.AuthorDAO;
import com.livraria.view.AuthorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.livraria.model.Authors;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AuthorController implements ControllerInterface {
    AuthorDAO authorDao;
    AuthorView authorView;

    public AuthorController(AuthorDAO authorDao, AuthorView authorView) {
        this.authorDao = authorDao;
        this.authorView = authorView;
    }

    public void startController() {
        // listener para o botão de adicionar autores
        authorView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    authorView.clearMessage();
                    validateInputNotEmpty(authorView.getNameInput(), authorView.getFNameInput());
                    String name = authorView.getNameInput();
                    String fName = authorView.getFNameInput();
                    Authors author = new Authors(name, fName);
                    boolean res = authorDao.addAuthors(author);
                    if(res) {
                        authorView.showMessage("Autor adicionado com sucesso");
                        System.out.println("Autor adicionado com sucesso");
                    } else {

                    }
                } catch (SQLIntegrityConstraintViolationException ex) {
                    authorView.showMessage("As informações inseridas estão incorretas");
                    System.out.println("As informações inseridas estão incorretas");
                } catch (ValidationException ve) {
                    System.out.println("Erro de validação: " + ve.getMessage());
                }
            }
        });

        // Listener para o botão de excluir autores
        authorView.delActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    authorView.clearMessage();
                    validateInputNotEmpty(authorView.getIdInput());
                    validateParseInt(authorView.getIdInput());
                    int authorId = Integer.parseInt(authorView.getIdInput());
                    boolean res = authorDao.deleteAuthorsAndBooks(authorId);
                    if(res) {
                        authorView.showMessage("Autor excluído com sucesso");
                        System.out.println("Autor excluído com sucesso");
                    } else {
                        authorView.showMessage("Não foi possível excluir o autor");
                        System.out.println("Não foi possível excluir o autor");
                    }
                } catch (SQLIntegrityConstraintViolationException e1) {
                    authorView.showMessage("Não foi possível excluir o autor");
                    System.out.println("Não foi possível excluir o autor");
                } catch (ValidationException ve) {
                    System.out.println("Erro de validação: " + ve.getMessage());
                }
            }
        });
        // listener para o botão de modificar autores
        authorView.modifyActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão funcionando");
            }
        });
        // listener para o botão de pesquisar autores
        authorView.searchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    authorView.clearMessage();
                    validateInputNotEmpty(authorView.getNameInput(), authorView.getFNameInput());
                    String name = authorView.getNameInput();
                    String fName = authorView.getFNameInput();
                    validateSearchOutputNotEmpty(authorDao, name, fName);
                    List<Authors> searchAuthorsList = authorDao.searchAuthors(name, fName);
                    DefaultListModel listModel = new DefaultListModel();
                    String[] columnNames = {"Nome", "Sobrenome"};
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    // guarda as instâncias de livros em listModel e adiciona as instâncias na tabela
                    for (Authors author : searchAuthorsList) {
                        listModel.addElement(author);
                        model.addRow(new Object[]{author.getName(), author.getFName()});
                    }
                    authorView.showSearchResult(model);
                } catch (ValidationException ve) {
                    System.out.println("Erro de validação: " + ve.getMessage());
                }
            }
        });
    }

    // Validações
    // Verifica se algum elemento foi encontrado na busca
    private void validateSearchOutputNotEmpty(AuthorDAO authorDao, String name, String fName) throws ValidationException {
        try {
            authorDao.searchAuthors(name, fName);
        } catch (IndexOutOfBoundsException ve) {
            authorView.showMessage("Nenhum autor encontrado");
            throw new ValidationException("Nenhum autor encontrado");
        }
    }
    // Verifica se o input não possui campos vazios
    private void validateInputNotEmpty(String... inputs) throws ValidationException {
        for(int i = 0; i < inputs.length; i++) {
            if(inputs[i].equals("")) {
                authorView.showMessage("Preencha todos os campos");
                throw new ValidationException("Preencha todos os campos");
            }
        }
    }
    // Verifica a possibilidade de um parseInt
    private void validateParseInt(String num) throws ValidationException {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException ve) {
            authorView.showMessage("Número inválido");
            throw new ValidationException("Número inválido");
        }
    }

    static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }
}
