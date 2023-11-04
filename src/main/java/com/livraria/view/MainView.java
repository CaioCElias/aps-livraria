package com.livraria.view;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private final JButton btnBook;
    private final JButton btnAuthor;
    private final JButton btnPublisher;
    private final CardLayout cardLayout;
    private final JPanel actionPanel;
    private final JButton[] bookBtns;
    private final JButton[] authorBtns;
    private final JButton[] publisherBtns;

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
        btnBook = new JButton("Livros");
        btnAuthor = new JButton("Autores");
        btnPublisher = new JButton("Editoras");
        mainPanel.add(btnBook);
        mainPanel.add(btnAuthor);
        mainPanel.add(btnPublisher);

        //Painel secundário
        actionPanel = new JPanel();
        cardLayout = new CardLayout();
        actionPanel.setLayout(cardLayout);

        //Painel geral de livros
        bookBtns = createPanel(actionPanel, "Livros", "Pesquisar", "Adicionar",
                "Modificar", "Excluir");

        //Painel geral de autores
        authorBtns = createPanel(actionPanel, "Autores", "Pesquisar", "Adicionar",
                "Modificar", "Excluir");

        //Painel geral de editoras
        publisherBtns = createPanel(actionPanel, "Editoras", "Pesquisar", "Adicionar",
                "Modificar", "Excluir");

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
            buttons[i] = button; // guarda uma referência do botão
        }
        return buttons;
    }

    //Listeners que direcionam para os paineis principais - livros | autores | editoras
    public void addBookSectionBtnListener(ActionListener l) {
        btnBook.addActionListener(l);
    }
    public void addAuthorSectionBtnListener(ActionListener l) {
        btnAuthor.addActionListener(l);
    }
    public void addPublisherSectionBtnListener(ActionListener l) {
        btnPublisher.addActionListener(l);
    }

    //Listeners dos botões do painel de livros
    public void addSearchBookSectionBtnListener(ActionListener l) {
        bookBtns[0].addActionListener(l);
    }
    public void addAddBookSectionBtnListener(ActionListener l) {
        bookBtns[1].addActionListener(l);
    }
    public void addModifyBookSectionBtnListener(ActionListener l) {
        bookBtns[2].addActionListener(l);
    }
    public void addDelBookSectionBtnListener(ActionListener l) {
        bookBtns[3].addActionListener(l);
    }

    //Listeners dos botões do painel de autores
    public void addSearchAuthorSectionBtnListener(ActionListener l) {
        authorBtns[0].addActionListener(l);
    }
    public void addAddAuthorSectionBtnListener(ActionListener l) {
        authorBtns[1].addActionListener(l);
    }
    public void addModifyAuthorSectionBtnListener(ActionListener l) {
        authorBtns[2].addActionListener(l);
    }
    public void addDelAuthorSectionBtnListener(ActionListener l) {
        authorBtns[3].addActionListener(l);
    }

    //Listeners dos botões do painel de editoras
    public void addSearchPublisherSectionBtnListener(ActionListener l) {
        publisherBtns[0].addActionListener(l);
    }
    public void addAddPublisherSectionBtnListener(ActionListener l) {
        publisherBtns[1].addActionListener(l);
    }
    public void addModifyPublisherSectionBtnListener(ActionListener l) {
        publisherBtns[2].addActionListener(l);
    }
    public void addDelPublisherSectionBtnListener(ActionListener l) {
        publisherBtns[3].addActionListener(l);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getActionPanel() {
        return actionPanel;
    }
}
