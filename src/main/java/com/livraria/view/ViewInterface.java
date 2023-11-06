package com.livraria.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public interface ViewInterface {

    // Popups do CRUD
    void addPopup();
    void deletePopup();
    void modifyPopup();
    void searchPopup();

    void clearDialog(JDialog dialog);
    void clearSearchPane();
    void clearMessage();
    void showSearchResult(DefaultTableModel model);
    void showMessage(String message);

    void addActionListener(ActionListener l);
    void delActionListener(ActionListener l);
    void modifyActionListener(ActionListener l);
    void searchActionListener(ActionListener l);
}
