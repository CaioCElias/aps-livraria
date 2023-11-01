package com.livraria.controller;

import com.livraria.dao.AuthorDAO;
import com.livraria.view.AuthorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.livraria.model.Authors;

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
                System.out.println("Botão funcionando");
            }
        });
        authorView.delActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                List<Authors> authorsList = authorDao.searchAuthorsTitle(name, fName);
                for (Authors author : authorsList) {
                    String authorsName = author.getName();
                    String authorsLastName = author.getFName();

                    System.out.println("Nome: " + authorsName);
                    System.out.println("Sobrenome: " + authorsLastName);
                }
                System.out.println("Botão funcionando");
            }
        });
    }
}
