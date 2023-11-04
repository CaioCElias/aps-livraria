package com.livraria.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class PublisherView implements ViewInterface {

    JDialog dialog = new JDialog();
    JPanel panel;
    private GridBagConstraints constraints = new GridBagConstraints();

    JLabel outputMsg;
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

    public void clearSearchPane() {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if ("publisherScrollPane".equals(component.getName())) {
                panel.remove(component);
                break;
            }
        }
    }

    public void showMessage(String message) {
        outputMsg.setText(message);
    }

    public void addPopup() {
        // Limpa a view
        showMessage("");
        clearDialog(dialog);
        // Define as variáveis, tamanho e título da view
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 300);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        nameTextField = new JTextField(20);
        urlTextField = new JTextField(20);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        // Adiciona os elementos ao painel da view
        dialog.add(panel);
        constraints.gridy = 0;
        panel.add(new JLabel("Adicionar Editora"), constraints);
        constraints.gridy = 1;
        panel.add(new JLabel("Nome"), constraints);
        panel.add(nameTextField, constraints);
        constraints.gridy = 2;
        panel.add(new JLabel("Site"), constraints);
        panel.add(urlTextField, constraints);
        //mensagem de output após ação do usuário
        constraints.gridy = 3;
        panel.add(outputMsg, constraints);

        constraints.gridy = 4;
        panel.add(addPublisherBtn, constraints);
        dialog.setVisible(true);
    }
    public void deletePopup() {
        // Limpa a view
        showMessage("");
        clearDialog(dialog);
        // Define as variáveis, tamanho e título da view
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 150);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        idTextField = new JTextField(20);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        // Adiciona os elementos ao painel da view
        dialog.add(panel);
        constraints.gridy = 0;
        panel.add(new JLabel("Excluir Editora"), constraints);
        // Mensagem de output após ação do usuário
        constraints.gridy = 1;
        panel.add(outputMsg, constraints);

        constraints.gridy = 2;
        panel.add(idTextField, constraints);
        panel.add(delPublisherBtn, constraints);
        dialog.setVisible(true);
    }

    public void modifyPopup() {
        // limpa a view
        showMessage("");
        clearDialog(dialog);
        // Define as variáveis, tamanho e título da view
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 300);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        nameTextField = new JTextField(20);
        urlTextField = new JTextField(20);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        // Adiciona os elementos ao painel da view
        dialog.add(panel);
        constraints.gridy = 0;
        panel.add(new JLabel("Modificar Editora"), constraints);
        constraints.gridy = 1;
        panel.add(new JLabel("Nome"), constraints);
        panel.add(nameTextField, constraints);
        constraints.gridy = 2;
        panel.add(new JLabel("Site"), constraints);
        panel.add(urlTextField, constraints);
        constraints.gridy = 3;
        panel.add(addPublisherBtn, constraints);
        dialog.setVisible(true);
    }
    public void searchPopup() {
        // Limpa a view
        showMessage("");
        clearDialog(dialog);
        // Define as variáveis, tamanho e título da view
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(550, 200);
        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        nameTextField = new JTextField(20);
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        // Adiciona os elementos ao painel da view
        dialog.add(panel);
        constraints.gridy = 0;
        panel.add(new JLabel("Pesquisar Editora"), constraints);
        constraints.gridy = 1;
        panel.add(new JLabel("Nome"), constraints);
        panel.add(nameTextField, constraints);
        constraints.gridy = 2;
        panel.add(searchPublisherBtn, constraints);
        dialog.setVisible(true);
    }

    public void showSearchResult(DefaultTableModel model) {
        // Remove a tabela para que outra seja inserida no lugar
        clearSearchPane();
        dialog.setSize(1100, 250);
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
        scrollPane.setName("publisherScrollPane");
        scrollPane.setPreferredSize(new Dimension(500, 100));
        // Adiciona o scrollPane ao painel
        panel.add(scrollPane, constraints);
        // Atualiza o painel
        panel.revalidate();
        panel.repaint();
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
