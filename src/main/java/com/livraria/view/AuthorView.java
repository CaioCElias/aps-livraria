package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorView extends JFrame {

    public AuthorView() {

    }

    //Popup de exclusão de autor
    public void deleteAuthorSection() {
        JDialog deleteBookDialog = new JDialog();
        deleteBookDialog.setTitle("Deletar Autor");
        deleteBookDialog.setSize(450, 150);

        JPanel deleteBookPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JButton deleteBookBtn = new JButton("Excluir");
        JTextField esbnTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);

        deleteBookDialog.add(deleteBookPanel);

        deleteConstraints.gridy = 0;
        deleteBookPanel.add(new JLabel("Excluir Autor"), deleteConstraints);
        deleteConstraints.gridy = 1;
        deleteBookPanel.add(esbnTextField, deleteConstraints);
        deleteBookPanel.add(deleteBookBtn, deleteConstraints);

        deleteBookDialog.setVisible(true);
    }
}
