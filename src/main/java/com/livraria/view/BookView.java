package com.livraria.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BookView implements ViewInterface {

    private final JDialog dialog = new JDialog();
    private JPanel panel;
    private GridBagConstraints constraints = new GridBagConstraints();
    private DefaultTableModel tableModel;
    private JTable table;

    private JTextField titleTextField;
    private JTextField isbnTextField;
    private JTextField priceTextField;
    private JTextField publisherTextField;

    JButton addBookBtn;
    JButton delBookBtn;
    JButton modifyBookBtn;
    JButton searchBookBtn;

    // recebe os autores com seus respectivos nomes
    String[] authors = {"Caio", "Gustavo"};

    public BookView() {
        addBookBtn = new JButton("Adicionar");
        delBookBtn = new JButton("Excluir");
        modifyBookBtn = new JButton("Modificar");
        searchBookBtn = new JButton("Pesquisar");

        //Inicializa a tabela de busca de livros
        String[] columnNames = {"Título", "Editora", "Preço"};
        tableModel = new DefaultTableModel(columnNames, 0);
    }

    private Vector<String> getColumnIdentifiers(DefaultTableModel model) {
        Vector<String> columnIdentifiers = new Vector<>();
        int columnCount = model.getColumnCount();
        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
            columnIdentifiers.add(model.getColumnName(columnIndex));
        }
        return columnIdentifiers;
    }

    public void clearDialog(JDialog dialog) {
        dialog.getContentPane().removeAll();
    }
    private void clearTable() {
        tableModel.setRowCount(0);
    }

    // Popup de Inclusão de livro
    public void addPopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(600, 400);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        titleTextField = new JTextField(20);
        isbnTextField = new JTextField(20);
        priceTextField = new JTextField(20);
        publisherTextField = new JTextField(20);
        //a lista de autores deve ser usada como input para a função JList
        JComboBox bookAuthorsBox = new JComboBox(authors);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        constraints.gridy = 0;
        panel.add(new JLabel("Adicionar Livro"), constraints);
        constraints.gridy = 1;
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
        constraints.gridy = 6;
        panel.add(addBookBtn, constraints);
        dialog.setVisible(true);
    }

    // Popup de exclusão de livro
    public void deletePopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 150);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JTextField isbnTextField = new JTextField(20);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        constraints.gridy = 0;
        panel.add(new JLabel("Excluir Livro"), constraints);
        constraints.gridy = 1;
        panel.add(isbnTextField, constraints);
        panel.add(delBookBtn, constraints);
        dialog.setVisible(true);
    }

    public void modifyPopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(600, 400);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        titleTextField = new JTextField(20);
        isbnTextField = new JTextField(20);
        priceTextField = new JTextField(20);
        publisherTextField = new JTextField(20);
        //a lista de autores deve ser usada como input para a função JList
        JComboBox bookAuthorsBox = new JComboBox(authors);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        constraints.gridy = 0;
        panel.add(new JLabel("Modificar Livro"), constraints);
        constraints.gridy = 1;
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
        constraints.gridy = 6;
        panel.add(addBookBtn, constraints);
        dialog.setVisible(true);
    }
    public void searchPopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(550, 250);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        titleTextField = new JTextField(20);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        constraints.gridy = 0;
        panel.add(new JLabel("Pesquisar Livro"), constraints);
        constraints.gridy = 1;
        panel.add(new JLabel("Título"), constraints);
        panel.add(titleTextField, constraints);
        constraints.gridy = 2;
        panel.add(searchBookBtn, constraints);
        dialog.setVisible(true);
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

    public void showBookList(DefaultTableModel model) {
        // remove a tabela para que outro seja inserido no lugar
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if ("bookScrollPane".equals(component.getName())) {
                panel.remove(component);
                break; // Assuming there's only one table with this name
            }
        }
        dialog.setSize(1100, 250);
        constraints.gridy = 1;
        // cria uma nova tabela
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);
        // define a largura de cada coluna
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(400);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(50);
        // cria um novo ScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setName("bookScrollPane");
        scrollPane.setPreferredSize(new Dimension(500, 100));
        // adiciona o scrollPane ao painel
        panel.add(scrollPane, constraints);
        // Atualiza o painel
        panel.revalidate();
        panel.repaint();
    }

    // listeners dos botões
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
