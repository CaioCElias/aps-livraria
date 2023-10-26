package com.livraria.controller;

import com.livraria.view.AuthorView;
import com.livraria.view.BookView;
import com.livraria.view.MainView;
import com.livraria.view.PublisherView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class MainController {
    MainView view;
    BookView bookView;
    AuthorView authorView;
    PublisherView publisherView;

    public MainController(MainView view, BookView bookView, AuthorView authorView, PublisherView publisherView) {
        this.view = view;
        this.bookView = bookView;
        this.authorView = authorView;
        this.publisherView = publisherView;

        //Listeners para os botões superiores da MainView
        view.addBookSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = view.getCardLayout();
                JPanel actionPanel = view.getActionPanel();
                cardLayout.show(actionPanel, "Livros");
            }
        });
        view.addAuthorSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = view.getCardLayout();
                JPanel actionPanel = view.getActionPanel();
                cardLayout.show(actionPanel, "Autores");
            }
        });
        view.addPublisherSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = view.getCardLayout();
                JPanel actionPanel = view.getActionPanel();
                cardLayout.show(actionPanel, "Editoras");
            }
        });

        //Listeners para os botões do painel de livros
        view.addSearchBookSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookView.searchPopup();
            }
        });
        view.addAddBookSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookView.addPopup();
            }
        });
        view.addModifyBookSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookView.modifyPopup();
            }
        });
        view.addDelBookSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookView.deletePopup();
            }
        });

        //Listeners para os botões do painel de autores
        view.addSearchAuthorSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorView.searchPopup();
            }
        });
        view.addAddAuthorSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorView.addPopup();
            }
        });
        view.addModifyAuthorSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorView.modifyPopup();
            }
        });
        view.addDelAuthorSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorView.deletePopup();
            }
        });

        //Listeners para os botões do painel de editoras
        view.addSearchPublisherSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                publisherView.searchPopup();
            }
        });
        view.addAddPublisherSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                publisherView.addPopup();
            }
        });
        view.addModifyPublisherSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                publisherView.modifyPopup();
            }
        });
        view.addDelPublisherSectionBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                publisherView.deletePopup();
            }
        });
    }
}
