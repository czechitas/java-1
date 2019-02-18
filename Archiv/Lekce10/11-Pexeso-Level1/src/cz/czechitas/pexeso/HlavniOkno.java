package cz.czechitas.pexeso;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.imageio.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import net.sevecek.util.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JLabel labKarta1;
    JLabel labKarta2;
    JLabel labKarta3;
    JLabel labKarta4;
    JLabel labKarta5;
    JLabel labKarta6;
    JLabel labKarta7;
    JLabel labKarta8;
    JLabel labKarta9;
    JLabel labKarta10;
    JLabel labKarta11;
    JLabel labKarta12;
    JLabel labKarta13;
    JLabel labKarta14;
    JLabel labKarta15;
    JLabel labKarta16;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;
    List<JLabel> seznamKaret;
    Icon obrazekRubuKaret;

    public HlavniOkno() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        labKarta1 = new JLabel();
        labKarta2 = new JLabel();
        labKarta3 = new JLabel();
        labKarta4 = new JLabel();
        labKarta5 = new JLabel();
        labKarta6 = new JLabel();
        labKarta7 = new JLabel();
        labKarta8 = new JLabel();
        labKarta9 = new JLabel();
        labKarta10 = new JLabel();
        labKarta11 = new JLabel();
        labKarta12 = new JLabel();
        labKarta13 = new JLabel();
        labKarta14 = new JLabel();
        labKarta15 = new JLabel();
        labKarta16 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pexeso");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 3",
            // columns
            "[grow,fill]" +
            "[70:n:70,fill]" +
            "[70:n:70,fill]" +
            "[70:n:70,fill]" +
            "[70:n:70,fill]" +
            "[grow,fill]",
            // rows
            "[grow,fill]" +
            "[70:n:70,fill]" +
            "[70:n:70,fill]" +
            "[70:n:70,fill]" +
            "[70:n:70,fill]" +
            "[grow]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //---- labKarta1 ----
        labKarta1.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/1.jpg")));
        contentPane.add(labKarta1, "cell 1 1");

        //---- labKarta2 ----
        labKarta2.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/1.jpg")));
        contentPane.add(labKarta2, "cell 2 1");

        //---- labKarta3 ----
        labKarta3.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/2.jpg")));
        contentPane.add(labKarta3, "cell 3 1");

        //---- labKarta4 ----
        labKarta4.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/2.jpg")));
        contentPane.add(labKarta4, "cell 4 1");

        //---- labKarta5 ----
        labKarta5.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/3.jpg")));
        contentPane.add(labKarta5, "cell 1 2");

        //---- labKarta6 ----
        labKarta6.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/3.jpg")));
        contentPane.add(labKarta6, "cell 2 2");

        //---- labKarta7 ----
        labKarta7.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/4.jpg")));
        contentPane.add(labKarta7, "cell 3 2");

        //---- labKarta8 ----
        labKarta8.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/4.jpg")));
        contentPane.add(labKarta8, "cell 4 2");

        //---- labKarta9 ----
        labKarta9.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/5.jpg")));
        contentPane.add(labKarta9, "cell 1 3");

        //---- labKarta10 ----
        labKarta10.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/5.jpg")));
        contentPane.add(labKarta10, "cell 2 3");

        //---- labKarta11 ----
        labKarta11.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/6.jpg")));
        contentPane.add(labKarta11, "cell 3 3");

        //---- labKarta12 ----
        labKarta12.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/6.jpg")));
        contentPane.add(labKarta12, "cell 4 3");

        //---- labKarta13 ----
        labKarta13.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/7.jpg")));
        contentPane.add(labKarta13, "cell 1 4");

        //---- labKarta14 ----
        labKarta14.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/7.jpg")));
        contentPane.add(labKarta14, "cell 2 4");

        //---- labKarta15 ----
        labKarta15.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/8.jpg")));
        contentPane.add(labKarta15, "cell 3 4");

        //---- labKarta16 ----
        labKarta16.setIcon(new ImageIcon(getClass().getResource("/cz/czechitas/pexeso/obrazky/8.jpg")));
        contentPane.add(labKarta16, "cell 4 4");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
