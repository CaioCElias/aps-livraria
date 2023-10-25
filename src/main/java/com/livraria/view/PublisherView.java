package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublisherView implements ViewInterface {

    public void addPopup() {
        JDialog addPublisherDialog = new JDialog();
        addPublisherDialog.setTitle("Livraria UNIP");
        addPublisherDialog.setSize(450, 300);

        JPanel addPublisherPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JButton addPublisherBtn = new JButton("Adicionar");
        JTextField nameTextField = new JTextField(20);
        JTextField siteTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);

        addPublisherDialog.add(addPublisherPanel);

        deleteConstraints.gridy = 0;
        addPublisherPanel.add(new JLabel("Adicionar Editora"), deleteConstraints);
        deleteConstraints.gridy = 1;
        addPublisherPanel.add(new JLabel("Nome"), deleteConstraints);
        addPublisherPanel.add(nameTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        addPublisherPanel.add(new JLabel("Site"), deleteConstraints);
        addPublisherPanel.add(siteTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        addPublisherPanel.add(addPublisherBtn, deleteConstraints);

        addPublisherBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        addPublisherDialog.setVisible(true);
    }
    public void deletePopup() {
        JDialog deleteBookDialog = new JDialog();
        deleteBookDialog.setTitle("Livraria UNIP");
        deleteBookDialog.setSize(450, 150);

        JPanel deleteBookPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JButton delPublisherBtn = new JButton("Excluir");
        JTextField publisherIdField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);

        deleteBookDialog.add(deleteBookPanel);

        deleteConstraints.gridy = 0;
        deleteBookPanel.add(new JLabel("Excluir Editora"), deleteConstraints);
        deleteConstraints.gridy = 1;
        deleteBookPanel.add(publisherIdField, deleteConstraints);
        deleteBookPanel.add(delPublisherBtn, deleteConstraints);

        delPublisherBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteBookDialog.setVisible(true);
    }

    public void modifyPopup() {

    }
    public void searchPopup() {

    }
}
