package com.livraria.controller;

import com.livraria.dao.AuthorDAO;
import com.livraria.view.AuthorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.livraria.model.Authors;
import com.livraria.model.Books;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AuthorController {
    AuthorDAO authorDao;
    AuthorView authorView;

    public AuthorController(AuthorDAO authorDao, AuthorView authorView) {
        this.authorDao = authorDao;
        this.authorView = authorView;
    }

    public void startAuthorController() {
        authorView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = authorView.getNameInput();
				String fName = authorView.getFNameInput();
				
				Authors author = new Authors(name, fName);

				try {
					authorDao.addAuthors(author);
				} catch (SQLIntegrityConstraintViolationException e1) {
					e1.printStackTrace();
				}
                System.out.println("Botão funcionando");
            }
        });
        authorView.delActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int authorId = authorView.getIdInput();

				try {
					authorDao.deleteAuthorsAndBooks(authorId);
				} catch (SQLIntegrityConstraintViolationException e1) {
					e1.printStackTrace();
				}
                System.out.println("Botão funcionando");
            }
        });
        authorView.modifyActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão funcionando");
            }
        });
        authorView.searchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = authorView.getNameInput();
                String fName = authorView.getFNameInput();
                List<Authors> searchAuthorsList = authorDao.searchAuthorsTitle(name, fName);
                DefaultListModel listModel = new DefaultListModel();
                // guarda as instâncias de autores em listModel
                for (Authors author : searchAuthorsList) {
                    listModel.addElement(author);
                }
                //adiciona as colunas da tabela
                String[] columnNames = {"Nome", "Sobrenome"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                for (Authors author : searchAuthorsList) {
                    model.addRow(new Object[]{author.getName(), author.getFName()});
                }
                authorView.showSearchResult(model);
            }
        });
    }
}
