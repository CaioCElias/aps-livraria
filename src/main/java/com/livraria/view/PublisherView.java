package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PublisherView implements ViewInterface {

    JDialog dialog = new JDialog();
    JPanel panel;

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

    public void clearDialog(JDialog dialog) {
        dialog.getContentPane().removeAll();
    }

    public void addPopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 300);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        nameTextField = new JTextField(20);
        urlTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        deleteConstraints.gridy = 0;
        panel.add(new JLabel("Adicionar Editora"), deleteConstraints);
        deleteConstraints.gridy = 1;
        panel.add(new JLabel("Nome"), deleteConstraints);
        panel.add(nameTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        panel.add(new JLabel("Site"), deleteConstraints);
        panel.add(urlTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        panel.add(addPublisherBtn, deleteConstraints);
        dialog.setVisible(true);
    }
    public void deletePopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 150);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        idTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        deleteConstraints.gridy = 0;
        panel.add(new JLabel("Excluir Editora"), deleteConstraints);
        deleteConstraints.gridy = 1;
        panel.add(idTextField, deleteConstraints);
        panel.add(delPublisherBtn, deleteConstraints);
        dialog.setVisible(true);
    }

    public void modifyPopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 300);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JTextField nameTextField = new JTextField(20);
        JTextField siteTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        deleteConstraints.gridy = 0;
        panel.add(new JLabel("Modificar Editora"), deleteConstraints);
        deleteConstraints.gridy = 1;
        panel.add(new JLabel("Nome"), deleteConstraints);
        panel.add(nameTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        panel.add(new JLabel("Site"), deleteConstraints);
        panel.add(siteTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        panel.add(addPublisherBtn, deleteConstraints);
        dialog.setVisible(true);
    }
    public void searchPopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(550, 200);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        nameTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        deleteConstraints.gridy = 0;
        panel.add(new JLabel("Pesquisar Editora"), deleteConstraints);
        deleteConstraints.gridy = 1;
        panel.add(new JLabel("Nome"), deleteConstraints);
        panel.add(nameTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        panel.add(searchPublisherBtn, deleteConstraints);
        dialog.setVisible(true);
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
