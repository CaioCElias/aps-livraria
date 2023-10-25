package com.livraria.view;

import javax.swing.*;
import java.awt.*;

public class PublisherView {
    public void deletePublisherSection() {
        JDialog deleteBookDialog = new JDialog();
        deleteBookDialog.setTitle("Livraria UNIP");
        deleteBookDialog.setSize(450, 150);

        JPanel deleteBookPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JButton deleteBookBtn = new JButton("Excluir");
        JTextField publisherId = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);

        deleteBookDialog.add(deleteBookPanel);

        deleteConstraints.gridy = 0;
        deleteBookPanel.add(new JLabel("Excluir Editora"), deleteConstraints);
        deleteConstraints.gridy = 1;
        deleteBookPanel.add(publisherId, deleteConstraints);
        deleteBookPanel.add(deleteBookBtn, deleteConstraints);

        deleteBookDialog.setVisible(true);
    }
}
