package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroView extends JFrame {

    private JPanel buttonPanel;
    private CardLayout cardLayout;

    public void initializeView() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    public LivroView() {
        JFrame mainFrame = new JFrame("Livro View");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);

        JPanel painel = new JPanel();

        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnIncluir = new JButton("Incluir");
        JButton btnModificar = new JButton("Modificar");
        JButton btnExcluir = new JButton("Excluir");

        buttonPanel = new JPanel();
        cardLayout = new CardLayout();
        buttonPanel.setLayout(cardLayout);

        GridBagConstraints constraints = new GridBagConstraints();
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);

        //Painel de pesquisa
        JPanel pesquisarPanel = new JPanel(new GridBagLayout());
        //constraints deve ser adicionado a cada elemento do painelpara que sejam dispostos
        // verticalmente
        buttonPanel.add(pesquisarPanel, "Pesquisar");
        JButton btnPesquisarLivro = new JButton("Livro");
        JButton btnPesquisarAutor = new JButton("Autor");
        JButton btnPesquisarEditora = new JButton("Editora");
        //define o layout do painel
        constraints.gridy = 0;
        pesquisarPanel.add(new JLabel("Pesquisar"));
        constraints.gridy = 1;
        pesquisarPanel.add(btnPesquisarLivro, constraints);
        constraints.gridy = 2;
        pesquisarPanel.add(btnPesquisarAutor, constraints);
        constraints.gridy = 3;
        pesquisarPanel.add(btnPesquisarEditora, constraints);

        //Painel de inclusão
        JPanel incluirPanel = new JPanel(new GridBagLayout());
        buttonPanel.add(incluirPanel, "Incluir");
        JButton btnIncluirLivro = new JButton("Livro");
        JButton btnIncluirAutor = new JButton("Autor");
        JButton btnIncluirEditora = new JButton("Editora");
        //define o layout do painel
        constraints.gridy = 0;
        incluirPanel.add(new JLabel("Incluir"));
        constraints.gridy = 1;
        incluirPanel.add(btnIncluirLivro, constraints);
        constraints.gridy = 2;
        incluirPanel.add(btnIncluirAutor, constraints);
        constraints.gridy = 3;
        incluirPanel.add(btnIncluirEditora, constraints);

        //Painel de modificação
        JPanel modificarPanel = new JPanel(new GridBagLayout());
        buttonPanel.add(modificarPanel, "Modificar");
        JButton btnModificarLivro = new JButton("Livro");
        JButton btnModificarAutor = new JButton("Autor");
        JButton btnModificarEditora= new JButton("Editora");
        //define o layout do painel
        constraints.gridy = 0;
        modificarPanel.add(new JLabel("Modificar"));
        constraints.gridy = 1;
        modificarPanel.add(btnModificarLivro, constraints);
        constraints.gridy = 2;
        modificarPanel.add(btnModificarAutor, constraints);
        constraints.gridy = 3;
        modificarPanel.add(btnModificarEditora, constraints);

        JPanel excluirPanel = new JPanel(new GridBagLayout());
        buttonPanel.add(excluirPanel, "Excluir");
        JButton btnExcluirLivro = new JButton("Livro");
        JButton btnExcluirAutor = new JButton("Autor");
        JButton btnExcluirEditora = new JButton("Editora");
        //define o layout do painel
        constraints.gridy = 0;
        excluirPanel.add(new JLabel("Excluir"));
        constraints.gridy = 1;
        excluirPanel.add(btnExcluirLivro, constraints);
        constraints.gridy = 2;
        excluirPanel.add(btnExcluirAutor, constraints);
        constraints.gridy = 3;
        excluirPanel.add(btnExcluirEditora, constraints);

        // Ação dos botões
        btnPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(buttonPanel, "Pesquisar");
            }
        });

        btnIncluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(buttonPanel, "Incluir");
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(buttonPanel, "Modificar");
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(buttonPanel, "Excluir");
            }
        });

        painel.add(btnPesquisar);
        painel.add(btnIncluir);
        painel.add(btnModificar);
        painel.add(btnExcluir);

        mainFrame.add(painel, BorderLayout.NORTH);
        mainFrame.add(buttonPanel, BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }
}
