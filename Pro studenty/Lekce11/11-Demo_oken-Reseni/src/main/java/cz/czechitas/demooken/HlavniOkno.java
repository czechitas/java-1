package cz.czechitas.demooken;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HlavniOkno extends JFrame {

    JButton btnStiskniMe;

    public HlavniOkno() {
        initComponents();
    }

    public void priStiskuBtnStiskniMe(ActionEvent kladkostroj) {
        kladkostroj.getSource();
        JOptionPane.showMessageDialog(this, "Ahoj lidi!");
    }


    private void initComponents() {
        this.setLayout(null);
        btnStiskniMe = new JButton("Stiskni mě");
        btnStiskniMe.setLocation(20, 20);
        btnStiskniMe.setSize(200, 40);
        btnStiskniMe.addActionListener(this::priStiskuBtnStiskniMe);
        this.add(btnStiskniMe);
    }
}
