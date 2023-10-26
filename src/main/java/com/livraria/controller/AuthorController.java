package com.livraria.controller;

import com.livraria.dao.AuthorDAO;
import com.livraria.view.AuthorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                System.out.println("Botão funcionando");
            }
        });
    }
}
