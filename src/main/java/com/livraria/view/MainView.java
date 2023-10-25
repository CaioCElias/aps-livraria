package com.livraria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    public void startMainView() {
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
        JButton btnBook = new JButton("Livros");
        JButton btnAuthor = new JButton("Autores");
        JButton btnPublisher = new JButton("Editoras");
        mainPanel.add(btnBook);
        mainPanel.add(btnAuthor);
        mainPanel.add(btnPublisher);

        //Instância das classes View
        BookView book = new BookView();
        AuthorView author = new AuthorView();
        PublisherView publisher = new PublisherView();

        //Painel secundário
        JPanel actionPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        actionPanel.setLayout(cardLayout);

        //Botões do painel principal
        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(actionPanel, "Livros");
            }
        });
        btnAuthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(actionPanel, "Autores");
            }
        });
        btnPublisher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(actionPanel, "Editoras");
            }
        });

        //Painel geral de livros
        JButton[] bookBtns = createPanel(actionPanel, "Livros", "Pesquisar", "Incluir",
                "Modificar", "Excluir");
        bookBtns[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.addPopup();
            }
        });
        bookBtns[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                book.deletePopup();
            }
        });

        //Painel geral de autores
        JButton[] authorBtns = createPanel(actionPanel, "Autores", "Pesquisar", "Incluir",
                "Modificar", "Excluir");
        authorBtns[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                author.addPopup();
            }
        });
        authorBtns[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                author.deletePopup();
            }
        });

        //Painel geral de editoras
        JButton[] publisherBtns = createPanel(actionPanel, "Editoras", "Pesquisar", "Incluir",
                "Modificar", "Excluir");
        publisherBtns[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                publisher.addPopup();
            }
        });
        publisherBtns[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                publisher.deletePopup();
            }
        });

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
