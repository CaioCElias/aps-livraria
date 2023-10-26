package com.livraria.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface ViewInterface {
    void addPopup();
    void deletePopup();
    void modifyPopup();
    void  searchPopup();

    void addActionListener(ActionListener l);
    void delActionListener(ActionListener l);
    void modifyActionListener(ActionListener l);
    void searchActionListener(ActionListener l);
}
