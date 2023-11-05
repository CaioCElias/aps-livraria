package com.livraria.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class AuthorView implements ViewInterface {

    JDialog dialog = new JDialog();
    JPanel panel;
    private GridBagConstraints constraints = new GridBagConstraints();

    JLabel outputMsg = new JLabel("");
    JTextField authorIdField;
    JTextField firstNameTextField;
    JTextField secondNameTextField;

    JButton addAuthorBtn;
    JButton delAuthorBtn;
    JButton modifyAuthorBtn;
    JButton searchAuthorBtn;

    public AuthorView() {
        addAuthorBtn = new JButton("Adicionar");
        delAuthorBtn = new JButton("Excluir");
        modifyAuthorBtn = new JButton("Modificar");
        searchAuthorBtn = new JButton("Pesquisar");
    }
    @Override
    public void clearDialog(JDialog dialog) {
        dialog.getContentPane().removeAll();
    }
    @Override
    public void clearSearchPane() {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if ("authorScrollPane".equals(component.getName())) {
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
    //Popup de inclusão de autor
    @Override
    public void addPopup() {
        // Limpa a view
        showMessage("");
        clearDialog(dialog);
        // Define as variáveis, tamanho e título da view
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(500, 300);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        firstNameTextField = new JTextField(20);
        secondNameTextField = new JTextField(20);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        // Adiciona os elementos ao painel da view
        dialog.add(panel);
        constraints.gridy = 0;
        panel.add(new JLabel("Adicionar Autor"), constraints);
        constraints.gridy = 1;
        panel.add(new JLabel("Primeiro nome"), constraints);
        panel.add(firstNameTextField, constraints);
        constraints.gridy = 2;
        panel.add(new JLabel("Segundo nome"), constraints);
        panel.add(secondNameTextField, constraints);

        //mensagem de output após ação do usuário
        this.constraints.gridy = 3;
        panel.add(outputMsg, this.constraints);

        constraints.gridy = 4;
        panel.add(addAuthorBtn, constraints);
        dialog.setVisible(true);
    }
    //Popup de exclusão de autor
    @Override
    public void deletePopup() {
        // Limpa a view
        showMessage("");
        clearDialog(dialog);
        // Define as variáveis, tamanho e título da view
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 200);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        authorIdField = new JTextField(20);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        // Adiciona os elementos ao painel da view
        dialog.add(panel);
        constraints.gridy = 0;
        panel.add(new JLabel("Excluir Autor"), constraints);
        constraints.gridy = 1;
        panel.add(authorIdField, constraints);
        panel.add(delAuthorBtn, constraints);

        //mensagem de output após ação do usuário
        this.constraints.gridy = 2;
        panel.add(outputMsg, this.constraints);

        dialog.setVisible(true);
    }
    @Override
    public void modifyPopup() {
        // Limpa a view
        showMessage("");
        clearDialog(dialog);
        // Define as variáveis, tamanho e título da view
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 350);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        firstNameTextField = new JTextField(20);
        secondNameTextField = new JTextField(20);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        // Adiciona os elementos ao painel da view
        dialog.add(panel);
        constraints.gridy = 0;
        panel.add(new JLabel("Modificar Autor"), constraints);
        constraints.gridy = 1;
        panel.add(new JLabel("Primeiro nome"), constraints);
        panel.add(firstNameTextField, constraints);
        constraints.gridy = 2;
        panel.add(new JLabel("Segundo nome"), constraints);
        panel.add(secondNameTextField, constraints);

        //mensagem de output após ação do usuário
        this.constraints.gridy = 3;
        panel.add(outputMsg, this.constraints);

        constraints.gridy = 4;
        panel.add(addAuthorBtn, constraints);
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
        firstNameTextField = new JTextField(20);
        secondNameTextField = new JTextField(20);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        // Adiciona os elementos ao painel da view
        dialog.add(panel);
        constraints.gridy = 0;
        panel.add(new JLabel("Pesquisar Autor"), constraints);
        constraints.gridy = 1;
        panel.add(new JLabel("Primeiro nome"), constraints);
        panel.add(firstNameTextField, constraints);
        constraints.gridy = 2;
        panel.add(new JLabel("Segundo nome"), constraints);
        panel.add(secondNameTextField, constraints);

        //mensagem de output após ação do usuário
        constraints.gridy = 3;
        panel.add(outputMsg, constraints);

        constraints.gridy = 4;
        panel.add(searchAuthorBtn, constraints);
        dialog.setVisible(true);
    }
    @Override
    public void showSearchResult(DefaultTableModel model) {
        // Limpa a view
        showMessage("");
        clearSearchPane();
        // Redimensiona a janela
        dialog.setSize(1100, 350);
        constraints.gridy = 1;
        // Cria uma nova tabela
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);
        // Define a largura de cada coluna
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setPreferredWidth(250);
        // Cria um novo ScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setName("authorScrollPane");
        scrollPane.setPreferredSize(new Dimension(500, 100));
        // Adiciona o scrollPane ao painel
        panel.add(scrollPane, constraints);
        // Atualiza o painel
        panel.revalidate();
        panel.repaint();
    }

    public String getIdInput() {
        return this.authorIdField.getText();
    }
    public String getNameInput() {
        return this.firstNameTextField.getText();
    }
    public String getFNameInput() {
        return this.secondNameTextField.getText();
    }

    // Listeners dos botões
    @Override
    public void addActionListener(ActionListener l) {
        addAuthorBtn.addActionListener(l);
    }
    @Override
    public void delActionListener(ActionListener l) {
        delAuthorBtn.addActionListener(l);
    }
    @Override
    public void modifyActionListener(ActionListener l) {
        modifyAuthorBtn.addActionListener(l);
    }
    @Override
    public void searchActionListener(ActionListener l) {
        searchAuthorBtn.addActionListener(l);
    }
}
