package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PublisherView implements ViewInterface {

    JTextField idTextField;
    JTextField nameTextField;
    JTextField urlTextField;

    JButton addPublisherBtn;
    JButton delPublisherBtn;
    JButton modifyPublisherBtn;
    JButton searchPublisherBtn;

    public PublisherView() {
        addPublisherBtn = new JButton("Adicionar");
        delPublisherBtn = new JButton("Excluir");
        modifyPublisherBtn = new JButton("Modificar");
        searchPublisherBtn = new JButton("Pesquisar");
    }

    public void addPopup() {
        JDialog addPublisherDialog = new JDialog();
        addPublisherDialog.setTitle("Livraria UNIP");
        addPublisherDialog.setSize(450, 300);
        JPanel addPublisherPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        nameTextField = new JTextField(20);
        urlTextField = new JTextField(20);
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
        addPublisherPanel.add(urlTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        addPublisherPanel.add(addPublisherBtn, deleteConstraints);
        addPublisherDialog.setVisible(true);
    }
    public void deletePopup() {
        JDialog deleteBookDialog = new JDialog();
        deleteBookDialog.setTitle("Livraria UNIP");
        deleteBookDialog.setSize(450, 150);
        JPanel deleteBookPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        idTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        deleteBookDialog.add(deleteBookPanel);
        deleteConstraints.gridy = 0;
        deleteBookPanel.add(new JLabel("Excluir Editora"), deleteConstraints);
        deleteConstraints.gridy = 1;
        deleteBookPanel.add(idTextField, deleteConstraints);
        deleteBookPanel.add(delPublisherBtn, deleteConstraints);
        deleteBookDialog.setVisible(true);
    }

    public void modifyPopup() {
        JDialog modifyPublisherDialog = new JDialog();
        modifyPublisherDialog.setTitle("Livraria UNIP");
        modifyPublisherDialog.setSize(450, 300);
        JPanel modifyPublisherPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JTextField nameTextField = new JTextField(20);
        JTextField siteTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        modifyPublisherDialog.add(modifyPublisherPanel);
        deleteConstraints.gridy = 0;
        modifyPublisherPanel.add(new JLabel("Modificar Editora"), deleteConstraints);
        deleteConstraints.gridy = 1;
        modifyPublisherPanel.add(new JLabel("Nome"), deleteConstraints);
        modifyPublisherPanel.add(nameTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        modifyPublisherPanel.add(new JLabel("Site"), deleteConstraints);
        modifyPublisherPanel.add(siteTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        modifyPublisherPanel.add(addPublisherBtn, deleteConstraints);
        modifyPublisherDialog.setVisible(true);
    }
    public void searchPopup() {
        JDialog searchPublisherDialog = new JDialog();
        searchPublisherDialog.setTitle("Livraria UNIP");
        searchPublisherDialog.setSize(550, 200);
        JPanel searchPublisherPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        nameTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        searchPublisherDialog.add(searchPublisherPanel);
        deleteConstraints.gridy = 0;
        searchPublisherPanel.add(new JLabel("Pesquisar Editora"), deleteConstraints);
        deleteConstraints.gridy = 1;
        searchPublisherPanel.add(new JLabel("Nome"), deleteConstraints);
        searchPublisherPanel.add(nameTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        searchPublisherPanel.add(searchPublisherBtn, deleteConstraints);
        searchPublisherDialog.setVisible(true);
    }

    public int getIdInput() {
        return Integer.parseInt(this.idTextField.getText());
    }
    public String getNameInput() {
        return this.nameTextField.getText();
    }
    public String getUrlInput() {
        return this.urlTextField.getText();
    }

    //listeners dos botões
    public void addActionListener(ActionListener l) {
        addPublisherBtn.addActionListener(l);
    }
    public void delActionListener(ActionListener l) {
        delPublisherBtn.addActionListener(l);
    }
    public void modifyActionListener(ActionListener l) {
        modifyPublisherBtn.addActionListener(l);
    }
    public void searchActionListener(ActionListener l) {
        searchPublisherBtn.addActionListener(l);
    }
}
