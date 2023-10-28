package com.livraria.controller;

import com.livraria.dao.PublisherDAO;
import com.livraria.model.Publishers;
import com.livraria.view.PublisherView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PublisherController {
    PublisherDAO publisherDao;
    PublisherView publisherView;

    public PublisherController(PublisherDAO publisherDao, PublisherView publisherView) {
        this.publisherDao = publisherDao;
        this.publisherView = publisherView;
    }

    public void startPublisherController() {
        publisherView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão funcionando");
            }
        });
        publisherView.delActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão funcionando");
            }
        });
        publisherView.modifyActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão funcionando");
            }
        });
        publisherView.searchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = publisherView.getNameInput();
                List<Publishers> publishersList = publisherDao.searchPublishersTitle(name);
                //atualizar na view
            }
        });
    }
}
