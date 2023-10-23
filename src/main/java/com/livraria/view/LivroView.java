package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroView extends JFrame {

    private JPanel actionPanel;
    private CardLayout cardLayout;

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
        JPanel painel = new JPanel();
        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnIncluir = new JButton("Incluir");
        JButton btnModificar = new JButton("Modificar");
        JButton btnExcluir = new JButton("Excluir");

        actionPanel = new JPanel();
        cardLayout = new CardLayout();
        actionPanel.setLayout(cardLayout);
        //constraints deve ser adicionado a cada elemento do painel para que sejam dispostos
        // verticalmente e com o padding correto

        //Painel geral de pesquisa
        JPanel pesquisarPanel = new JPanel(new GridBagLayout());
        actionPanel.add(pesquisarPanel, "Pesquisar");
        JButton btnPesquisarLivro = new JButton("Livro");
        JButton btnPesquisarAutor = new JButton("Autor");
        JButton btnPesquisarEditora = new JButton("Editora");
        definePanelConstraints(pesquisarPanel, btnPesquisarLivro, btnPesquisarAutor, btnPesquisarEditora, "Pesquisar");

        //Painel geral de inclusão
        JPanel incluirPanel = new JPanel(new GridBagLayout());
        actionPanel.add(incluirPanel, "Incluir");
        JButton btnIncluirLivro = new JButton("Livro");
        JButton btnIncluirAutor = new JButton("Autor");
        JButton btnIncluirEditora = new JButton("Editora");
        definePanelConstraints(incluirPanel, btnIncluirLivro, btnIncluirAutor, btnIncluirEditora, "Incluir");

        //Painel geral de modificação
        JPanel modificarPanel = new JPanel(new GridBagLayout());
        actionPanel.add(modificarPanel, "Modificar");
        JButton btnModificarLivro = new JButton("Livro");
        JButton btnModificarAutor = new JButton("Autor");
        JButton btnModificarEditora= new JButton("Editora");
        definePanelConstraints(modificarPanel, btnModificarLivro, btnModificarAutor, btnModificarEditora, "Modificar");

        //Painel geral de exclusão
        JPanel excluirPanel = new JPanel(new GridBagLayout());
        actionPanel.add(excluirPanel, "Excluir");
        JButton btnExcluirLivro = new JButton("Livro");
        JButton btnExcluirAutor = new JButton("Autor");
        JButton btnExcluirEditora = new JButton("Editora");
        definePanelConstraints(excluirPanel, btnExcluirLivro, btnExcluirAutor, btnExcluirEditora, "Excluir");

        //Botões do painel principal
        btnPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(actionPanel, "Pesquisar");
            }
        });
        btnIncluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(actionPanel, "Incluir");
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(actionPanel, "Modificar");
            }
        });
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(actionPanel, "Excluir");
            }
        });

        //Botões do painel de pesquisa
        btnPesquisarLivro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(actionPanel, "Pesquisar livro");
            }
        });

        painel.add(btnPesquisar);
        painel.add(btnIncluir);
        painel.add(btnModificar);
        painel.add(btnExcluir);

        mainFrame.add(painel, BorderLayout.NORTH);
        mainFrame.add(actionPanel, BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }

    //Define um painel com layout vertical e 10px de padding em todas as direções
    private void definePanelConstraints(JPanel panel, JButton btnBook, JButton btnAuthor, JButton btnEditor,
                                        String jlabel) {
        GridBagConstraints constraints = new GridBagConstraints();
        int padding = 10;
        constraints.insets = new Insets(padding, padding, padding, padding);
        //define o layout do painel
        constraints.gridy = 0;
        panel.add(new JLabel(jlabel));
        constraints.gridy = 1;
        panel.add(btnBook, constraints);
        constraints.gridy = 2;
        panel.add(btnAuthor, constraints);
        constraints.gridy = 3;
        panel.add(btnEditor, constraints);
    }
}
