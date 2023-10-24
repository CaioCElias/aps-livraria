package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroView extends JFrame {

    public void initializeView() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    public LivroView() {
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
        createPanel(actionPanel, "Pesquisar", "Livro", "Autor", "Editora");
        JPanel pesquisarPanel = new JPanel(new GridBagLayout());


        //Painel geral de inclusão
        createPanel(actionPanel, "Incluir", "Livro", "Autor", "Editora");

        //Painel geral de modificação
        createPanel(actionPanel, "Modificar", "Livro", "Autor", "Editora");

        //Painel geral de exclusão
        createPanel(actionPanel, "Excluir", "Livro", "Autor", "Editora");

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
    public static void createPanel(Container container, String panelName, String... buttonLabels) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);

        container.add(panel, panelName);

        constraints.gridy = 0;
        panel.add(new JLabel(panelName));

        for (String label : buttonLabels) {
            constraints.gridy++;
            JButton button = new JButton(label);
            panel.add(button, constraints);
        }
    }
}
