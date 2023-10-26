package com.livraria.controller;

import com.livraria.view.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    MainView view;

    public MainController(MainView view) {
        this.view = view;

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
    }
}
