package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BookView implements ViewInterface {

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

    //Popup de Inclusão de livro
    public void addPopup() {
        JDialog addBookDialog = new JDialog();
        addBookDialog.setTitle("Livraria UNIP");
        addBookDialog.setSize(600, 400);
        JPanel addBookPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        titleTextField = new JTextField(20);
        isbnTextField = new JTextField(20);
        priceTextField = new JTextField(20);
        publisherTextField = new JTextField(20);
        //a lista de autores deve ser usada como input para a função JList
        JComboBox bookAuthorsBox = new JComboBox(authors);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        addBookDialog.add(addBookPanel);
        deleteConstraints.gridy = 0;
        addBookPanel.add(new JLabel("Adicionar Livro"), deleteConstraints);
        deleteConstraints.gridy = 1;
        addBookPanel.add(new JLabel("Título"), deleteConstraints);
        addBookPanel.add(titleTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        addBookPanel.add(new JLabel("ISBN"), deleteConstraints);
        addBookPanel.add(isbnTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        addBookPanel.add(new JLabel("Preço"), deleteConstraints);
        addBookPanel.add(priceTextField, deleteConstraints);
        deleteConstraints.gridy = 4;
        addBookPanel.add(new JLabel("Editora"), deleteConstraints);
        addBookPanel.add(publisherTextField, deleteConstraints);
        deleteConstraints.gridy = 5;
        addBookPanel.add(bookAuthorsBox, deleteConstraints);
        deleteConstraints.gridy = 6;
        addBookPanel.add(addBookBtn, deleteConstraints);
        addBookDialog.setVisible(true);
    }

    //Popup de exclusão de livro
    public void deletePopup() {
        JDialog deleteBookDialog = new JDialog();
        deleteBookDialog.setTitle("Livraria UNIP");
        deleteBookDialog.setSize(450, 150);
        JPanel delBookPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JTextField isbnTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        deleteBookDialog.add(delBookPanel);
        deleteConstraints.gridy = 0;
        delBookPanel.add(new JLabel("Excluir Livro"), deleteConstraints);
        deleteConstraints.gridy = 1;
        delBookPanel.add(isbnTextField, deleteConstraints);
        delBookPanel.add(delBookBtn, deleteConstraints);
        deleteBookDialog.setVisible(true);
    }

    public void modifyPopup() {
        JDialog modifyBookDialog = new JDialog();
        modifyBookDialog.setTitle("Livraria UNIP");
        modifyBookDialog.setSize(600, 400);
        JPanel modifyBookPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        titleTextField = new JTextField(20);
        isbnTextField = new JTextField(20);
        priceTextField = new JTextField(20);
        publisherTextField = new JTextField(20);
        //a lista de autores deve ser usada como input para a função JList
        JComboBox bookAuthorsBox = new JComboBox(authors);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        modifyBookDialog.add(modifyBookPanel);
        deleteConstraints.gridy = 0;
        modifyBookPanel.add(new JLabel("Modificar Livro"), deleteConstraints);
        deleteConstraints.gridy = 1;
        modifyBookPanel.add(new JLabel("Título"), deleteConstraints);
        modifyBookPanel.add(titleTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        modifyBookPanel.add(new JLabel("ISBN"), deleteConstraints);
        modifyBookPanel.add(isbnTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        modifyBookPanel.add(new JLabel("Preço"), deleteConstraints);
        modifyBookPanel.add(priceTextField, deleteConstraints);
        deleteConstraints.gridy = 4;
        modifyBookPanel.add(new JLabel("Editora"), deleteConstraints);
        modifyBookPanel.add(publisherTextField, deleteConstraints);
        deleteConstraints.gridy = 5;
        modifyBookPanel.add(bookAuthorsBox, deleteConstraints);
        deleteConstraints.gridy = 6;
        modifyBookPanel.add(addBookBtn, deleteConstraints);
        modifyBookDialog.setVisible(true);
    }
    public void searchPopup() {
        JDialog searchBookDialog = new JDialog();
        searchBookDialog.setTitle("Livraria UNIP");
        searchBookDialog.setSize(550, 250);
        JPanel searchBookPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        titleTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        searchBookDialog.add(searchBookPanel);
        deleteConstraints.gridy = 0;
        searchBookPanel.add(new JLabel("Pesquisar Livro"), deleteConstraints);
        deleteConstraints.gridy = 1;
        searchBookPanel.add(new JLabel("Título"), deleteConstraints);
        searchBookPanel.add(titleTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        searchBookPanel.add(searchBookBtn, deleteConstraints);
        searchBookDialog.setVisible(true);
    }

    public String getTitleInput() {
        return this.titleTextField.getText();
    }
    public String getIsbnInput() {
        return this.isbnTextField.getText();
    }
    public String getPriceInput() {
        return this.priceTextField.getText();
    }
    public String getPublisherInput() {
        return this.publisherTextField.getText();
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
