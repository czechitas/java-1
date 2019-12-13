package cz.czechitas.demomysi;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labPlocha;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;

    public HlavniOkno() {
        initComponents();
    }

    private void priKliknutiMysiNaLabel(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        setTitle("Kliknuti mysi na [" + x + ", " + y + "]");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labPlocha = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DemoKliknutiMysi");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets rel,hidemode 3",
            // columns
            "[grow,fill]",
            // rows
            "[grow,fill]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //---- labPlocha ----
        labPlocha.setBackground(new Color(255, 255, 204));
        labPlocha.setOpaque(true);
        labPlocha.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                priKliknutiMysiNaLabel(e);
            }
        });
        contentPane.add(labPlocha, "cell 0 0");
        setSize(470, 341);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
