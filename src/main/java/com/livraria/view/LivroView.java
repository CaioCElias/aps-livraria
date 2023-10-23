package com.livraria.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroView extends JFrame {

    public void initializeView() {
        SwingUtilities.invokeLater(() -> {
            LivroView janela = new LivroView();
            janela.setVisible(true);
        });
    }

    public LivroView() {
        // Configurações da janela
        setTitle("Livraria UNIP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        // Crie um painel para conter os componentes
        JPanel painel = new JPanel();
        add(painel);

        // Botões
        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnIncluir = new JButton("Incluir");
        JButton btnModificar = new JButton("Modificar");
        JButton btnExcluir = new JButton("Excluir");

        // Ação dos botões
        btnPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LivroView.this, "Botão foi clicado!");
            }
        });

        btnIncluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LivroView.this, "Botão foi clicado!");
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LivroView.this, "Botão foi clicado!");
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LivroView.this, "Botão foi clicado!");
            }
        });

        painel.add(btnPesquisar);
        painel.add(btnIncluir);
        painel.add(btnModificar);
        painel.add(btnExcluir);
    }
}
