package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroGUI extends JFrame {
    public LivroGUI() {
        // Configurações da janela
        setTitle("Minha Livraria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Crie um painel para conter os componentes
        JPanel painel = new JPanel();
        add(painel);

        // Botão
        JButton botao = new JButton("Clique aqui");

        // Ação do botão
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LivroGUI.this, "Botão foi clicado!");
            }
        });

        painel.add(botao);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LivroGUI janela = new LivroGUI();
            janela.setVisible(true);
        });
    }
}
