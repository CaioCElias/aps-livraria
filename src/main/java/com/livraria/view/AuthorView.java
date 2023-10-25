package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorView implements ViewInterface {

    public AuthorView() {

    }

    public void addPopup() {
        JDialog addAuthorDialog = new JDialog();
        addAuthorDialog.setTitle("Livraria UNIP");
        addAuthorDialog.setSize(450, 300);

        JPanel addAuthorPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JButton addAuthorBtn = new JButton("Adicionar");
        JTextField firstNameTextField = new JTextField(20);
        JTextField secondNameTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);

        addAuthorDialog.add(addAuthorPanel);

        deleteConstraints.gridy = 0;
        addAuthorPanel.add(new JLabel("Adicionar Autor"), deleteConstraints);
        deleteConstraints.gridy = 1;
        addAuthorPanel.add(new JLabel("Primeiro nome"), deleteConstraints);
        addAuthorPanel.add(firstNameTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        addAuthorPanel.add(new JLabel("Segundo nome"), deleteConstraints);
        addAuthorPanel.add(secondNameTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        addAuthorPanel.add(addAuthorBtn, deleteConstraints);

        addAuthorBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        addAuthorDialog.setVisible(true);
    }

    //Popup de exclusão de autor
    public void deletePopup() {
        JDialog deleteBookDialog = new JDialog();
        deleteBookDialog.setTitle("Livraria UNIP");
        deleteBookDialog.setSize(450, 150);

        JPanel delAuthorPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JButton delAuthorBtn = new JButton("Excluir");
        JTextField authorIdField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);

        deleteBookDialog.add(delAuthorPanel);

        deleteConstraints.gridy = 0;
        delAuthorPanel.add(new JLabel("Excluir Autor"), deleteConstraints);
        deleteConstraints.gridy = 1;
        delAuthorPanel.add(authorIdField, deleteConstraints);
        delAuthorPanel.add(delAuthorBtn, deleteConstraints);

        delAuthorBtn.addActionListener(new ActionListener() {
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
