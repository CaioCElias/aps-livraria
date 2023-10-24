package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    public void initializeView() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    public MainView() {
        JFrame mainFrame = new JFrame("Livraria UNIP");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);

        //Painel principal
        JPanel mainPanel = new JPanel();
        JButton btnSearch = new JButton("Pesquisar");
        JButton btnInclude = new JButton("Incluir");
        JButton btnModify = new JButton("Modificar");
        JButton btnDelete = new JButton("Excluir");

        //Painel secundário
        JPanel actionPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        actionPanel.setLayout(cardLayout);
        //constraints deve ser adicionado a cada elemento do painel para que sejam dispostos
        // verticalmente e com o padding correto

        //Painel geral de pesquisa
        JButton[] searchBtns;
        searchBtns = createPanel(actionPanel, "Pesquisar", "Livro", "Autor", "Editora");

        //Painel geral de inclusão
        JButton[] includeBtns;
        includeBtns = createPanel(actionPanel, "Incluir", "Livro", "Autor", "Editora");

        //Painel geral de modificação
        JButton[] modifyBtns;
        modifyBtns = createPanel(actionPanel, "Modificar", "Livro", "Autor", "Editora");

        //Painel geral de exclusão
        JButton[] deleteBtns;
        deleteBtns = createPanel(actionPanel, "Excluir", "Livro", "Autor", "Editora");
        //Popup de exclusão de livro
        JDialog deleteBookDialog = new JDialog();
        deleteBookDialog.setTitle("Deletar Livro");
        deleteBookDialog.setSize(400, 300);

        JPanel deleteBookPanel = new JPanel(new GridBagLayout());
        GridBagConstraints deleteConstraints = new GridBagConstraints();
        JButton deleteBookBtn = new JButton("Excluir");
        JTextField esbnTextField = new JTextField(20);
        int padding = 10;
        deleteConstraints.insets = new Insets(padding, padding, padding, padding);

        deleteBookDialog.add(deleteBookPanel);

        deleteConstraints.gridy = 0;
        deleteBookPanel.add(new JLabel("Excluir Livro"));
        deleteConstraints.gridy = 1;
        deleteBookPanel.add(deleteBookBtn);
        deleteBookPanel.add(esbnTextField);

        deleteBtns[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Apertado");
                deleteBookDialog.setVisible(true);
            }
        });


        //Botões do painel principal
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(actionPanel, "Pesquisar");
            }
        });
        btnInclude.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(actionPanel, "Incluir");
            }
        });
        btnModify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(actionPanel, "Modificar");
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(actionPanel, "Excluir");
            }
        });

        mainPanel.add(btnSearch);
        mainPanel.add(btnInclude);
        mainPanel.add(btnModify);
        mainPanel.add(btnDelete);

        mainFrame.add(mainPanel, BorderLayout.NORTH);
        mainFrame.add(actionPanel, BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }

    //Função responsável pela criação dos paineis ao clicar nos botões superiores
    public static JButton[] createPanel(Container container, String panelName, String... buttonLabels) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);

        container.add(panel, panelName);

        constraints.gridy = 0;
        panel.add(new JLabel(panelName));

        JButton[] buttons = new JButton[buttonLabels.length];

        for (int i = 0; i < buttonLabels.length; i++) {
            constraints.gridy++;
            JButton button = new JButton(buttonLabels[i]);
            panel.add(button, constraints);
            buttons[i] = button; // Store a reference to the button
        }

        return buttons;
    }
}
