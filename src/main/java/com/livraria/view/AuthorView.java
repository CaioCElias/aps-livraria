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

    public void clearDialog(JDialog dialog) {
        dialog.getContentPane().removeAll();
    }

    public void clearSearchPane() {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if ("authorScrollPane".equals(component.getName())) {
                panel.remove(component);
                break;
            }
        }
    }

    public void addPopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 300);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        firstNameTextField = new JTextField(20);
        secondNameTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        deleteConstraints.gridy = 0;
        panel.add(new JLabel("Adicionar Autor"), deleteConstraints);
        deleteConstraints.gridy = 1;
        panel.add(new JLabel("Primeiro nome"), deleteConstraints);
        panel.add(firstNameTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        panel.add(new JLabel("Segundo nome"), deleteConstraints);
        panel.add(secondNameTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        panel.add(addAuthorBtn, deleteConstraints);
        dialog.setVisible(true);
    }

    //Popup de exclusão de autor
    public void deletePopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 150);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        authorIdField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        deleteConstraints.gridy = 0;
        panel.add(new JLabel("Excluir Autor"), deleteConstraints);
        deleteConstraints.gridy = 1;
        panel.add(authorIdField, deleteConstraints);
        panel.add(delAuthorBtn, deleteConstraints);
        dialog.setVisible(true);
    }

    public void modifyPopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(450, 300);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        firstNameTextField = new JTextField(20);
        secondNameTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        deleteConstraints.gridy = 0;
        panel.add(new JLabel("Modificar Autor"), deleteConstraints);
        deleteConstraints.gridy = 1;
        panel.add(new JLabel("Primeiro nome"), deleteConstraints);
        panel.add(firstNameTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        panel.add(new JLabel("Segundo nome"), deleteConstraints);
        panel.add(secondNameTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        panel.add(addAuthorBtn, deleteConstraints);
        dialog.setVisible(true);
    }
    public void searchPopup() {
        clearDialog(dialog);
        dialog.setTitle("Livraria UNIP");
        dialog.setSize(550, 250);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        firstNameTextField = new JTextField(20);
        secondNameTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);
        dialog.add(panel);
        deleteConstraints.gridy = 0;
        panel.add(new JLabel("Pesquisar Autor"), deleteConstraints);
        deleteConstraints.gridy = 1;
        panel.add(new JLabel("Primeiro nome"), deleteConstraints);
        panel.add(firstNameTextField, deleteConstraints);
        deleteConstraints.gridy = 2;
        panel.add(new JLabel("Segundo nome"), deleteConstraints);
        panel.add(secondNameTextField, deleteConstraints);
        deleteConstraints.gridy = 3;
        panel.add(searchAuthorBtn, deleteConstraints);
        dialog.setVisible(true);
    }

    public void showSearchResult(DefaultTableModel model) {
        // remove a tabela para que outra seja inserida no lugar
        clearSearchPane();
        dialog.setSize(1100, 300);
        constraints.gridy = 1;
        // cria uma nova tabela
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);
        // define a largura de cada coluna
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setPreferredWidth(250);
        // cria um novo ScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setName("authorScrollPane");
        scrollPane.setPreferredSize(new Dimension(500, 100));
        // adiciona o scrollPane ao painel
        panel.add(scrollPane, constraints);
        // Atualiza o painel
        panel.revalidate();
        panel.repaint();
    }

    public int getIdInput() {
        return Integer.parseInt(this.authorIdField.getText());
    }
    public String getNameInput() {
        return this.firstNameTextField.getText();
    }
    public String getFNameInput() {
        return this.secondNameTextField.getText();
    }


    //listeners dos botões
    public void addActionListener(ActionListener l) {
        addAuthorBtn.addActionListener(l);
    }
    public void delActionListener(ActionListener l) {
        delAuthorBtn.addActionListener(l);
    }
    public void modifyActionListener(ActionListener l) {
        modifyAuthorBtn.addActionListener(l);
    }
    public void searchActionListener(ActionListener l) {
        searchAuthorBtn.addActionListener(l);
    }
}
