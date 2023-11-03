package com.livraria.controller;

import com.livraria.dao.PublisherDAO;
import com.livraria.model.Authors;
import com.livraria.model.Publishers;
import com.livraria.view.PublisherView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
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
                String name = publisherView.getNameInput();
				String url = publisherView.getUrlInput();
				
				Publishers publisher = new Publishers(name, url);

				try {
					publisherDao.addPublishers(publisher);
				} catch (SQLIntegrityConstraintViolationException e1) {
					e1.printStackTrace();
				}
                System.out.println("Botão funcionando");
            }
        });
        publisherView.delActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int publisherId = publisherView.getIdInput();

				try {
					publisherDao.deletePublisherAndBooks(publisherId);
				} catch (SQLIntegrityConstraintViolationException e1) {
					e1.printStackTrace();
				}
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
                List<Publishers> searchPublishersList = publisherDao.searchPublishersTitle(name);
                DefaultListModel listModel = new DefaultListModel();
                //atualizar na view
                // guarda as instâncias de autores em listModel
                for (Publishers publisher : searchPublishersList) {
                    listModel.addElement(publisher);
                }
                //adiciona as colunas da tabela
                String[] columnNames = {"Nome", "Site"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                for (Publishers publisher : searchPublishersList) {
                    model.addRow(new Object[]{publisher.getName(), publisher.getUrl()});
                }
                publisherView.showSearchResult(model);
            }
        });
    }
}
