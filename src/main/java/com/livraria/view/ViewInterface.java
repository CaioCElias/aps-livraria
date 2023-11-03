package com.livraria.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public interface ViewInterface {
    void addPopup();
    void deletePopup();
    void modifyPopup();
    void searchPopup();

    void clearDialog(JDialog dialog);
    void clearSearchPane();
    void showSearchResult(DefaultTableModel model);

    void addActionListener(ActionListener l);
    void delActionListener(ActionListener l);
    void modifyActionListener(ActionListener l);
    void searchActionListener(ActionListener l);
}
