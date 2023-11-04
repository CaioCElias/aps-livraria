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
        // listener para o botão de adicionar editoras
        publisherView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = publisherView.getNameInput();
				String url = publisherView.getUrlInput();
				
				Publishers publisher = new Publishers(name, url);

				try {
					boolean res = publisherDao.addPublishers(publisher);
                    if(res) {
                        publisherView.showMessage("Editora adicionada com sucesso");
                    } else {
                        publisherView.showMessage("Não foi possivel adicionar a editora");
                    }
				} catch (SQLIntegrityConstraintViolationException e1) {
					e1.printStackTrace();
				}
                System.out.println("Botão funcionando");
            }
        });
        // listener para o botão de excluir editoras
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
        // listener para o botão de modificar editoras
        publisherView.modifyActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão funcionando");
            }
        });
        // listener para o botão de pesquisar editoras
        publisherView.searchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = publisherView.getNameInput();
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
            }
        });
    }
}
