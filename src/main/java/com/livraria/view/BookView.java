package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BookView implements ViewInterface {

    private final JDialog dialog = new JDialog();
    private JPanel panel;

    private JTextField titleTextField;
    private JTextField isbnTextField;
    private JTextField priceTextField;
    private JTextField publisherTextField;

    JButton addBookBtn;
    JButton delBookBtn;
    JButton modifyBookBtn;
    JButton searchBookBtn;

    //recebe os autores com seus respectivos nomes
    String[] authors = {"Caio", "Gustavo"};

    public BookView() {
        addBookBtn = new JButton("Adicionar");
        delBookBtn = new JButton("Excluir");
        modifyBookBtn = new JButton("Modificar");
        searchBookBtn = new JButton("Pesquisar");
    }

    public void clearDialog(JDialog dialog) {
        dialog.getContentPane().removeAll();
    }

    //Popup de Inclusão de livro
    public void addPopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(600, 400);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        titleTextField = new JTextField(20);
        isbnTextField = new JTextField(20);
        priceTextField = new JTextField(20);
        publisherTextField = new JTextField(20);
        //a lista de autores deve ser usada como input para a função JList
        JComboBox bookAuthorsBox = new JComboBox(authors);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        deleteConstraints.gridy = 0;
        panel.add(new JLabel("Adicionar Livro"), deleteConstraints);
        deleteConstraints.gridy = 1;
        panel.add(new JLabel("Título"), deleteConstraints);
        panel.add(titleTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        panel.add(new JLabel("ISBN"), deleteConstraints);
        panel.add(isbnTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        panel.add(new JLabel("Preço"), deleteConstraints);
        panel.add(priceTextField, deleteConstraints);
        deleteConstraints.gridy = 4;
        panel.add(new JLabel("Editora"), deleteConstraints);
        panel.add(publisherTextField, deleteConstraints);
        deleteConstraints.gridy = 5;
        panel.add(bookAuthorsBox, deleteConstraints);
        deleteConstraints.gridy = 6;
        panel.add(addBookBtn, deleteConstraints);
        dialog.setVisible(true);
    }

    //Popup de exclusão de livro
    public void deletePopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 150);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JTextField isbnTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        deleteConstraints.gridy = 0;
        panel.add(new JLabel("Excluir Livro"), deleteConstraints);
        deleteConstraints.gridy = 1;
        panel.add(isbnTextField, deleteConstraints);
        panel.add(delBookBtn, deleteConstraints);
        dialog.setVisible(true);
    }

    public void modifyPopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(600, 400);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        titleTextField = new JTextField(20);
        isbnTextField = new JTextField(20);
        priceTextField = new JTextField(20);
        publisherTextField = new JTextField(20);
        //a lista de autores deve ser usada como input para a função JList
        JComboBox bookAuthorsBox = new JComboBox(authors);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        deleteConstraints.gridy = 0;
        panel.add(new JLabel("Modificar Livro"), deleteConstraints);
        deleteConstraints.gridy = 1;
        panel.add(new JLabel("Título"), deleteConstraints);
        panel.add(titleTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        panel.add(new JLabel("ISBN"), deleteConstraints);
        panel.add(isbnTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        panel.add(new JLabel("Preço"), deleteConstraints);
        panel.add(priceTextField, deleteConstraints);
        deleteConstraints.gridy = 4;
        panel.add(new JLabel("Editora"), deleteConstraints);
        panel.add(publisherTextField, deleteConstraints);
        deleteConstraints.gridy = 5;
        panel.add(bookAuthorsBox, deleteConstraints);
        deleteConstraints.gridy = 6;
        panel.add(addBookBtn, deleteConstraints);
        dialog.setVisible(true);
    }
    public void searchPopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(550, 250);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        titleTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        deleteConstraints.gridy = 0;
        panel.add(new JLabel("Pesquisar Livro"), deleteConstraints);
        deleteConstraints.gridy = 1;
        panel.add(new JLabel("Título"), deleteConstraints);
        panel.add(titleTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        panel.add(searchBookBtn, deleteConstraints);
        dialog.setVisible(true);
    }

    public String getTitleInput() {
        return this.titleTextField.getText();
    }
    public String getIsbnInput() {
        return this.isbnTextField.getText();
    }
    public String getPriceInput() {
        return this.isbnTextField.getText();
    }
    public String getPublisherInput() {
        return this.publisherTextField.getText();
    }
    public JDialog getDialog() {
        return this.dialog;
    }

    //listeners dos botões
    public void addActionListener(ActionListener l) {
        addBookBtn.addActionListener(l);
    }
    public void delActionListener(ActionListener l) {
        delBookBtn.addActionListener(l);
    }
    public void modifyActionListener(ActionListener l) {
        modifyBookBtn.addActionListener(l);
    }
    public void searchActionListener(ActionListener l) {
        searchBookBtn.addActionListener(l);
    }
}
