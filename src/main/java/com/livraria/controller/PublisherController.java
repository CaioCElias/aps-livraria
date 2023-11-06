package com.livraria.controller;

import com.livraria.dao.PublisherDAO;
import com.livraria.model.Publishers;
import com.livraria.view.PublisherView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class PublisherController implements ControllerInterface {
    PublisherDAO publisherDao;
    PublisherView publisherView;

    public PublisherController(PublisherDAO publisherDao, PublisherView publisherView) {
        this.publisherDao = publisherDao;
        this.publisherView = publisherView;
    }

    public void startController() {
        // Listener para o botão de adicionar editoras
        publisherView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    publisherView.clearMessage();
                    validateInputNotEmpty(publisherView.getNameInput(), publisherView.getUrlInput());
                    String name = publisherView.getNameInput();
                    String url = publisherView.getUrlInput();
                    Publishers publisher = new Publishers(name, url);
                    boolean res = publisherDao.addPublishers(publisher);
                    if (res) {
                        publisherView.showMessage("Editora adicionada com sucesso");
                    } else {
                        publisherView.showMessage("Não foi possivel adicionar a editora");
                    }
                    System.out.println("Botão funcionando");
                } catch (SQLIntegrityConstraintViolationException e1) {
                    e1.printStackTrace();
                } catch (ValidationException ve) {
                    System.out.println("Erro de validação: " + ve.getMessage());
                }
            }
        });
        // Listener para o botão de excluir editoras
        publisherView.delActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    publisherView.clearMessage();
                    validateInputNotEmpty(publisherView.getIdInput());
                    validateParseInt(publisherView.getIdInput());
                    int publisherId = Integer.parseInt(publisherView.getIdInput());
                    boolean res = publisherDao.deletePublisherAndBooks(publisherId);
                    if(res) {
                        publisherView.showMessage("Editora excluída com sucesso");
                        System.out.println("Editora excluída com sucesso");
                    } else {
                        publisherView.showMessage("Não foi possível excluir a editora");
                        System.out.println("Não foi possível excluir a editora");
                    }
                } catch (SQLIntegrityConstraintViolationException e1) {
                    publisherView.showMessage("As informações inseridas estão incorretas");
                    System.out.println("As informações inseridas estão incorretas");
                } catch (ValidationException ve) {
                    System.out.println("Erro de validação: " + ve.getMessage());
                }
            }
        });
        // Listener para o botão de modificar editoras
        publisherView.modifyActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                publisherView.clearMessage();
                System.out.println("Botão funcionando");
            }
        });
        // Listener para o botão de pesquisar editoras
        publisherView.searchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    publisherView.clearMessage();
                    validateInputNotEmpty(publisherView.getNameInput());
                    String name = publisherView.getNameInput();
                    validateSearchOutputNotEmpty(publisherDao, name);
                    List<Publishers> searchPublishersList = publisherDao.searchPublishersTitle(name);
                    DefaultListModel listModel = new DefaultListModel();
                    //atualizar na view
                    String[] columnNames = {"Nome", "Site"};
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    // guarda as instâncias de autores em listModel e adiciona as instâncias na tabela
                    for (Publishers publisher : searchPublishersList) {
                        listModel.addElement(publisher);
                        model.addRow(new Object[]{publisher.getName(), publisher.getUrl()});
                    }
                    publisherView.showSearchResult(model);
                } catch (ValidationException ve) {
                    System.out.println("Erro de validação: " + ve.getMessage());
                }
            }
        });
    }
    // Validações
    // Verifica se algum elemento foi encontrado na busca
    private void validateSearchOutputNotEmpty(PublisherDAO publisherDao, String name) throws ValidationException {
        try {
            publisherDao.searchPublishersTitle(name);
        } catch (IndexOutOfBoundsException ve) {
            publisherView.showMessage("Nenhuma editora encontrada");
            throw new ValidationException("Nenhuma editora encontrada");
        }
    }
    // Verifica se o input não possui campos vazios
    public void validateInputNotEmpty(String... inputs) throws ValidationException {
        for(int i = 0; i < inputs.length; i++) {
            if(inputs[i].equals("")) {
                publisherView.showMessage("Preencha todos os campos");
                throw new ValidationException("Preencha todos os campos");
            }
        }
    }
    // Verifica a possibilidade de um parseInt
    private void validateParseInt(String num) throws ValidationException {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException ve) {
            publisherView.showMessage("Id inválido");
            throw new ValidationException("Número inválido");
        }
    }

    static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }
}
