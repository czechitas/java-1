package cz.czechitas.kalkulacka;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JTextField editCeleCislo;
    JButton btnTlacitko7;
    JButton btnTlacitko8;
    JButton btnTlacitko9;
    JButton btnTlacitko4;
    JButton btnTlacitko5;
    JButton btnTlacitko6;
    JButton btnTlacitko1;
    JButton btnTlacitko2;
    JButton btnTlacitko3;
    JButton btnTlacitko0;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;

    public HlavniOkno() {
        initComponents();
    }

    private void priStiskuBtnTlacitkoCislo(ActionEvent e) {
        JButton tlacitko = (JButton) e.getSource();
        String cislice = tlacitko.getText();

        String puvodniCeleCislo = editCeleCislo.getText();
        String noveCeleCislo = puvodniCeleCislo + cislice;
        editCeleCislo.setText(noveCeleCislo);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        editCeleCislo = new JTextField();
        btnTlacitko7 = new JButton();
        btnTlacitko8 = new JButton();
        btnTlacitko9 = new JButton();
        btnTlacitko4 = new JButton();
        btnTlacitko5 = new JButton();
        btnTlacitko6 = new JButton();
        btnTlacitko1 = new JButton();
        btnTlacitko2 = new JButton();
        btnTlacitko3 = new JButton();
        btnTlacitko0 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kalkulacka");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets rel,hidemode 3",
            // columns
            "[grow,fill]" +
            "[grow,fill]" +
            "[grow,fill]",
            // rows
            "[fill]" +
            "[grow]" +
            "[grow]" +
            "[grow]" +
            "[grow]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //---- editCeleCislo ----
        editCeleCislo.setHorizontalAlignment(SwingConstants.TRAILING);
        contentPane.add(editCeleCislo, "cell 0 0 3 1");

        //---- btnTlacitko7 ----
        btnTlacitko7.setText("7");
        btnTlacitko7.addActionListener(e -> priStiskuBtnTlacitkoCislo(e));
        contentPane.add(btnTlacitko7, "cell 0 1");

        //---- btnTlacitko8 ----
        btnTlacitko8.setText("8");
        btnTlacitko8.addActionListener(e -> priStiskuBtnTlacitkoCislo(e));
        contentPane.add(btnTlacitko8, "cell 1 1");

        //---- btnTlacitko9 ----
        btnTlacitko9.setText("9");
        btnTlacitko9.addActionListener(e -> priStiskuBtnTlacitkoCislo(e));
        contentPane.add(btnTlacitko9, "cell 2 1");

        //---- btnTlacitko4 ----
        btnTlacitko4.setText("4");
        btnTlacitko4.addActionListener(e -> priStiskuBtnTlacitkoCislo(e));
        contentPane.add(btnTlacitko4, "cell 0 2");

        //---- btnTlacitko5 ----
        btnTlacitko5.setText("5");
        btnTlacitko5.addActionListener(e -> priStiskuBtnTlacitkoCislo(e));
        contentPane.add(btnTlacitko5, "cell 1 2");

        //---- btnTlacitko6 ----
        btnTlacitko6.setText("6");
        btnTlacitko6.addActionListener(e -> priStiskuBtnTlacitkoCislo(e));
        contentPane.add(btnTlacitko6, "cell 2 2");

        //---- btnTlacitko1 ----
        btnTlacitko1.setText("1");
        btnTlacitko1.addActionListener(e -> priStiskuBtnTlacitkoCislo(e));
        contentPane.add(btnTlacitko1, "cell 0 3");

        //---- btnTlacitko2 ----
        btnTlacitko2.setText("2");
        btnTlacitko2.addActionListener(e -> priStiskuBtnTlacitkoCislo(e));
        contentPane.add(btnTlacitko2, "cell 1 3");

        //---- btnTlacitko3 ----
        btnTlacitko3.setText("3");
        btnTlacitko3.addActionListener(e -> priStiskuBtnTlacitkoCislo(e));
        contentPane.add(btnTlacitko3, "cell 2 3");

        //---- btnTlacitko0 ----
        btnTlacitko0.setText("0");
        btnTlacitko0.addActionListener(e -> priStiskuBtnTlacitkoCislo(e));
        contentPane.add(btnTlacitko0, "cell 0 4 2 1");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
