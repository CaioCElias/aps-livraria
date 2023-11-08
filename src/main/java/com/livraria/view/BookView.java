package com.livraria.view;

import com.livraria.model.Books;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class BookView implements ViewInterface {

    private final JDialog dialog = new JDialog();
    private JPanel panel;
    private GridBagConstraints constraints = new GridBagConstraints();

    JList<String> authors;
    DefaultTableModel authorsModel;
    JTable authorsTable = new JTable(authorsModel);

    private JLabel outputMsg = new JLabel("");
    private JTextField titleTextField;
    private JTextField isbnTextField;
    private JTextField priceTextField;
    private JTextField publisherTextField;

    JButton addBookBtn;
    JButton delBookBtn;
    JButton modifyBookBtn;
    JButton searchBookBtn;

    // recebe os autores com seus respectivos nomes

    public BookView() {
        addBookBtn = new JButton("Adicionar");
        delBookBtn = new JButton("Excluir");
        modifyBookBtn = new JButton("Modificar");
        searchBookBtn = new JButton("Pesquisar");
    }
    @Override
    public void clearDialog(JDialog dialog) {
        dialog.getContentPane().removeAll();
    }
    @Override
    public void clearSearchPane() {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if ("bookScrollPane".equals(component.getName())) {
                panel.remove(component);
                break;
            }
        }
    }
    @Override
    public void clearMessage() {
        outputMsg.setText("");
    }
    @Override
    public void showMessage(String message) {
        outputMsg.setText(message);
    }
    // Popup de Inclusão de livro
    @Override
    public void addPopup() {
        // Limpa a view
        showMessage("");
        clearDialog(dialog);
        // Define as variáveis, tamanho e título da view
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(600, 500);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        titleTextField = new JTextField(20);
        isbnTextField = new JTextField(20);
        priceTextField = new JTextField(20);
        publisherTextField = new JTextField(20);
        // A lista de autores deve ser usada como input para a função JList
        authorsTable = new JTable(authorsModel);
        authorsTable.setFillsViewportHeight(true);
        TableColumnModel columnModel = authorsTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(0).setPreferredWidth(150);
        System.out.println(authorsTable.getValueAt(0, 0));
        JScrollPane scrollPane = new JScrollPane(authorsTable);
        scrollPane.setName("Autores");
        scrollPane.setPreferredSize(new Dimension(350, 150));
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        // Adiciona os elementos ao painel da view
        dialog.add(panel);
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        panel.add(new JLabel("Adicionar Livro"), constraints);
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(new JLabel("Título"), constraints);
        panel.add(titleTextField, constraints);
        constraints.gridy = 2;
        panel.add(new JLabel("ISBN"), constraints);
        panel.add(isbnTextField, constraints);
        constraints.gridy = 3;
        panel.add(new JLabel("Preço"), constraints);
        panel.add(priceTextField, constraints);
        constraints.gridy = 4;
        panel.add(new JLabel("Editora"), constraints);
        panel.add(publisherTextField, constraints);
        constraints.gridy = 5;
        constraints.gridwidth = 3;
        panel.add(scrollPane, constraints);

        //mensagem de output após ação do usuário
        constraints.gridy = 6;
        panel.add(outputMsg, constraints);

        constraints.gridy = 7;
        panel.add(addBookBtn, constraints);
        dialog.setVisible(true);
    }
    // Popup de exclusão de livro
    @Override
    public void deletePopup() {
        // Limpa a view
        showMessage("");
        clearDialog(dialog);
        // Define as variáveis, tamanho e título da view
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(550, 200);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        isbnTextField = new JTextField(20);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        // Adiciona os elementos ao painel da view
        dialog.add(panel);
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        panel.add(new JLabel("Excluir Livro"), constraints);
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(new JLabel("ISBN"), constraints);
        panel.add(isbnTextField, constraints);
        panel.add(delBookBtn, constraints);

        //mensagem de output após ação do usuário
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        panel.add(outputMsg, constraints);

        dialog.setVisible(true);
    }
    @Override
    public void modifyPopup() {
        // Limpa a view
        showMessage("");
        clearDialog(dialog);
        // Define as variáveis, tamanho e título da view
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(600, 500);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        titleTextField = new JTextField(20);
        isbnTextField = new JTextField(20);
        priceTextField = new JTextField(20);
        publisherTextField = new JTextField(20);
        // A lista de autores deve ser usada como input para a função JList
        ScrollPane bookAuthorsBox = new ScrollPane();
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        // Adiciona os elementos ao painel da view
        dialog.add(panel);
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        panel.add(new JLabel("Modificar Livro"), constraints);
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(new JLabel("Título"), constraints);
        panel.add(titleTextField, constraints);
        constraints.gridy = 2;
        panel.add(new JLabel("ISBN"), constraints);
        panel.add(isbnTextField, constraints);
        constraints.gridy = 3;
        panel.add(new JLabel("Preço"), constraints);
        panel.add(priceTextField, constraints);
        constraints.gridy = 4;
        panel.add(new JLabel("Editora"), constraints);
        panel.add(publisherTextField, constraints);
        constraints.gridy = 5;
        panel.add(bookAuthorsBox, constraints);

        //mensagem de output após ação do usuário
        constraints.gridy = 6;
        constraints.gridwidth = 3;
        panel.add(outputMsg, constraints);

        constraints.gridy = 7;
        panel.add(addBookBtn, constraints);
        dialog.setVisible(true);
    }
    @Override
    public void searchPopup() {
        // Limpa a view
        showMessage("");
        clearDialog(dialog);
        // Define as variáveis, tamanho e título da view
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(550, 250);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        titleTextField = new JTextField(20);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        // Adiciona os elementos ao painel da view
        dialog.add(panel);
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        panel.add(new JLabel("Pesquisar Livro"), constraints);
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(new JLabel("Título"), constraints);
        panel.add(titleTextField, constraints);

        //mensagem de output após ação do usuário
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        panel.add(outputMsg, constraints);

        constraints.gridy = 3;
        panel.add(searchBookBtn, constraints);
        dialog.setVisible(true);
    }
    @Override
    public void showSearchResult(DefaultTableModel model) {
        // Limpa a view
        showMessage("");
        clearSearchPane();
        // Redimensiona a janela
        dialog.setSize(1100, 300);
        constraints.gridy = 1;
        // Cria uma nova tabela
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);
        // Define a largura de cada coluna
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(400);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(50);
        // Cria um novo ScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setName("bookScrollPane");
        scrollPane.setPreferredSize(new Dimension(500, 100));
        // Adiciona o scrollPane ao painel
        panel.add(scrollPane, constraints);
        // Atualiza o painel
        panel.revalidate();
        panel.repaint();
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
    public JTable getAuthorsTable() {
        return this.authorsTable;
    }

    public void setAuthorsList(JList authors, DefaultTableModel authorsModel) {
        this.authors = authors;
        this.authorsModel = authorsModel;
    }

    public void setTableModel(DefaultTableModel model) {
        this.authorsModel = model;
    }

    // Listeners dos botões
    @Override
    public void addActionListener(ActionListener l) {
        addBookBtn.addActionListener(l);
    }
    @Override
    public void delActionListener(ActionListener l) {
        delBookBtn.addActionListener(l);
    }
    @Override
    public void modifyActionListener(ActionListener l) {
        modifyBookBtn.addActionListener(l);
    }
    @Override
    public void searchActionListener(ActionListener l) {
        searchBookBtn.addActionListener(l);
    }
}
