package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.livraria.dao.BookDAO;

public class BookView implements ViewInterface {

    JButton searchBookBtn;

    //recebe os autores com seus respectivos nomes
    String[] authors = {"Caio", "Gustavo"};
    BookDAO bookDAO = new BookDAO();

    public BookView() {

    }

    //Popup de Inclusão de livro
    public void addPopup() {
        JDialog addBookDialog = new JDialog();
        addBookDialog.setTitle("Livraria UNIP");
        addBookDialog.setSize(600, 400);

        JPanel addBookPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JButton addBookBtn = new JButton("Adicionar");
        JTextField bookNameTextField = new JTextField(20);
        JTextField bookEsbnTextField = new JTextField(20);
        JTextField bookPriceTextField = new JTextField(20);
        JTextField bookPublisherTextField = new JTextField(20);
        //a lista de autores deve ser usada como input para a função JList
        JComboBox bookAuthorsBox = new JComboBox(authors);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);

        addBookDialog.add(addBookPanel);

        deleteConstraints.gridy = 0;
        addBookPanel.add(new JLabel("Adicionar Livro"), deleteConstraints);
        deleteConstraints.gridy = 1;
        addBookPanel.add(new JLabel("Título"), deleteConstraints);
        addBookPanel.add(bookNameTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        addBookPanel.add(new JLabel("ESBN"), deleteConstraints);
        addBookPanel.add(bookEsbnTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        addBookPanel.add(new JLabel("Preço"), deleteConstraints);
        addBookPanel.add(bookPriceTextField, deleteConstraints);
        deleteConstraints.gridy = 4;
        addBookPanel.add(new JLabel("Editora"), deleteConstraints);
        addBookPanel.add(bookPublisherTextField, deleteConstraints);
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
        JButton delBookBtn = new JButton("Excluir");
        JTextField esbnTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);

        deleteBookDialog.add(delBookPanel);

        deleteConstraints.gridy = 0;
        delBookPanel.add(new JLabel("Excluir Livro"), deleteConstraints);
        deleteConstraints.gridy = 1;
        delBookPanel.add(esbnTextField, deleteConstraints);
        delBookPanel.add(delBookBtn, deleteConstraints);

        delBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteBookDialog.setVisible(true);
    }

    public void modifyPopup() {

    }
    public void searchPopup() {
        JDialog searchBookDialog = new JDialog();
        searchBookDialog.setTitle("Livraria UNIP");
        searchBookDialog.setSize(450, 150);

        JPanel searchBookPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        searchBookBtn = new JButton("Pesquisar");
        JTextField bookTitleTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);

        searchBookDialog.add(searchBookPanel);

        deleteConstraints.gridy = 0;
        searchBookPanel.add(new JLabel("Pesquisar Livro"), deleteConstraints);
        deleteConstraints.gridy = 1;
        searchBookPanel.add(bookTitleTextField, deleteConstraints);
        searchBookPanel.add(searchBookBtn, deleteConstraints);

        searchBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookDAO.searchBooksByName("the");
            }
        });

        searchBookDialog.setVisible(true);
    }

    public void addBookSearchActionListener(ActionListener listener) {
        searchBookBtn.addActionListener(listener);
    }
}
