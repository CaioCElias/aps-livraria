package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorView implements ViewInterface {

    public AuthorView() {

    }

    public void addPopup() {

    }

    //Popup de exclusão de autor
    public void deletePopup() {
        JDialog deleteBookDialog = new JDialog();
        deleteBookDialog.setTitle("Livraria UNIP");
        deleteBookDialog.setSize(450, 150);

        JPanel deleteBookPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JButton delAuthorBtn = new JButton("Excluir");
        JTextField authorIdField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);

        deleteBookDialog.add(deleteBookPanel);

        deleteConstraints.gridy = 0;
        deleteBookPanel.add(new JLabel("Excluir Autor"), deleteConstraints);
        deleteConstraints.gridy = 1;
        deleteBookPanel.add(authorIdField, deleteConstraints);
        deleteBookPanel.add(delAuthorBtn, deleteConstraints);

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
