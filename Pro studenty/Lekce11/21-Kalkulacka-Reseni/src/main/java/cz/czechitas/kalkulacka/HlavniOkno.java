package cz.czechitas.kalkulacka;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JMenuBar mbarMenu;
    JMenu menuEdit;
    JMenu menuView;
    JMenu menuHelp;
    JTextField editText;
    JTextField editPrazdne;
    JButton btnBackspace;
    JButton btnCE;
    JButton btnC;
    JButton btnMC;
    JButton btn7;
    JButton btn8;
    JButton btn9;
    JButton btnLomeno;
    JButton btnSqrt;
    JButton btnMR;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    JButton btnNasobeni;
    JButton btnProcento;
    JButton btnMS;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btnMinus;
    JButton btn1lomenoX;
    JButton btnMplus;
    JButton btn0;
    JButton btnPlusMinus;
    JButton btnTecka;
    JButton btnPlus;
    JButton btnRovnitko;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;

    public HlavniOkno() {
        initComponents();
    }

    private void priStiskuBtnCislice(ActionEvent e) {
        JButton komponenta = (JButton) e.getSource();
        pridejCisliciDoRadku(komponenta.getText());
    }

    private void pridejCisliciDoRadku(String cislice) {
        String cislo = "";
        if (editText.getText().equals("0")) {   // když je na kalkulačce 0, napiš číslici
            editText.setText(cislice);
        } else {                                // když už tam není nula, doplň další číslici
            cislo = editText.getText();
            cislo = cislo + cislice;
            editText.setText(cislo);
        }
    }

    private void priStiskuBtnCE(ActionEvent e) {
        editText.setText("0");                 // nastav kalkulačku na 0
    }

    private void priStiskuBtnTecka(ActionEvent e) {
        String text = editText.getText();
        if (text.contains(".")) {              // pokud už jedna desetinná tečka je, tak další nechci
            editText.setText(text);
        } else {                               // pokud tečka není, tak ji udělej
            editText.setText(text + ".");
        }
    }

    private void priStiskuBtnPlusMinus(ActionEvent e) {
        String text = editText.getText();
        if (text.startsWith("-")) {            // když je číslo záporné
            text = text.replace("-", "");
            editText.setText(text);
        } else {
            if (text.equals("0")) {            // když je nula, tak mínus nedávám
                editText.setText("0");
            } else {
                editText.setText("-" + text);  // když je číslo kladné
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        mbarMenu = new JMenuBar();
        menuEdit = new JMenu();
        menuView = new JMenu();
        menuHelp = new JMenu();
        editText = new JTextField();
        editPrazdne = new JTextField();
        btnBackspace = new JButton();
        btnCE = new JButton();
        btnC = new JButton();
        btnMC = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        btnLomeno = new JButton();
        btnSqrt = new JButton();
        btnMR = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btnNasobeni = new JButton();
        btnProcento = new JButton();
        btnMS = new JButton();
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btnMinus = new JButton();
        btn1lomenoX = new JButton();
        btnMplus = new JButton();
        btn0 = new JButton();
        btnPlusMinus = new JButton();
        btnTecka = new JButton();
        btnPlus = new JButton();
        btnRovnitko = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calculator");
        setForeground(Color.red);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 3",
            // columns
            "[fill]" +
            "[41,grow,sizegroup 1,fill]15" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[40,grow,sizegroup 1,fill]" +
            "[43,grow,sizegroup 1,fill]" +
            "[34,grow,sizegroup 1,fill]" +
            "[fill]",
            // rows
            "[]" +
            "[fill]" +
            "[22,sizegroup 1]" +
            "[sizegroup 1]" +
            "[sizegroup 1]" +
            "[sizegroup 1]" +
            "[sizegroup 1]" +
            "[]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //======== mbarMenu ========
        {

            //======== menuEdit ========
            {
                menuEdit.setText("Edit");
            }
            mbarMenu.add(menuEdit);

            //======== menuView ========
            {
                menuView.setText("View");
            }
            mbarMenu.add(menuView);

            //======== menuHelp ========
            {
                menuHelp.setText("Help");
            }
            mbarMenu.add(menuHelp);
        }
        setJMenuBar(mbarMenu);

        //---- editText ----
        editText.setHorizontalAlignment(SwingConstants.TRAILING);
        editText.setText("0");
        editText.setFont(editText.getFont().deriveFont(editText.getFont().getSize() + 6f));
        contentPane.add(editText, "cell 1 1 6 1");

        //---- editPrazdne ----
        editPrazdne.setEditable(false);
        contentPane.add(editPrazdne, "cell 1 2,growy");

        //---- btnBackspace ----
        btnBackspace.setText("Backspace");
        btnBackspace.setForeground(Color.red);
        btnBackspace.setFont(btnBackspace.getFont().deriveFont(btnBackspace.getFont().getSize() + 4f));
        contentPane.add(btnBackspace, "cell 2 2 2 1,growx");

        //---- btnCE ----
        btnCE.setText("CE");
        btnCE.setForeground(Color.blue);
        btnCE.setFont(btnCE.getFont().deriveFont(btnCE.getFont().getSize() + 4f));
        btnCE.addActionListener(e -> priStiskuBtnCE(e));
        contentPane.add(btnCE, "cell 4 2 3 1");

        //---- btnC ----
        btnC.setText("C");
        btnC.setForeground(Color.red);
        btnC.setFont(btnC.getFont().deriveFont(btnC.getFont().getSize() + 4f));
        contentPane.add(btnC, "cell 4 2 3 1");

        //---- btnMC ----
        btnMC.setText("MC");
        btnMC.setForeground(Color.red);
        btnMC.setFont(btnMC.getFont().deriveFont(btnMC.getFont().getSize() + 4f));
        contentPane.add(btnMC, "cell 1 3");

        //---- btn7 ----
        btn7.setText("7");
        btn7.setForeground(Color.blue);
        btn7.setFont(btn7.getFont().deriveFont(btn7.getFont().getSize() + 4f));
        btn7.addActionListener(e -> priStiskuBtnCislice(e));
        contentPane.add(btn7, "cell 2 3");

        //---- btn8 ----
        btn8.setText("8");
        btn8.setForeground(Color.blue);
        btn8.setFont(btn8.getFont().deriveFont(btn8.getFont().getSize() + 4f));
        btn8.addActionListener(e -> priStiskuBtnCislice(e));
        contentPane.add(btn8, "cell 3 3");

        //---- btn9 ----
        btn9.setText("9");
        btn9.setForeground(Color.blue);
        btn9.setFont(btn9.getFont().deriveFont(btn9.getFont().getSize() + 4f));
        btn9.addActionListener(e -> priStiskuBtnCislice(e));
        contentPane.add(btn9, "cell 4 3");

        //---- btnLomeno ----
        btnLomeno.setText("/");
        btnLomeno.setForeground(Color.red);
        btnLomeno.setFont(btnLomeno.getFont().deriveFont(btnLomeno.getFont().getSize() + 4f));
        contentPane.add(btnLomeno, "cell 5 3");

        //---- btnSqrt ----
        btnSqrt.setText("sqrt");
        btnSqrt.setForeground(Color.red);
        btnSqrt.setFont(btnSqrt.getFont().deriveFont(btnSqrt.getFont().getSize() + 4f));
        contentPane.add(btnSqrt, "cell 6 3");

        //---- btnMR ----
        btnMR.setText("MR");
        btnMR.setForeground(Color.red);
        btnMR.setFont(btnMR.getFont().deriveFont(btnMR.getFont().getSize() + 4f));
        contentPane.add(btnMR, "cell 1 4");

        //---- btn4 ----
        btn4.setText("4");
        btn4.setForeground(Color.blue);
        btn4.setFont(btn4.getFont().deriveFont(btn4.getFont().getSize() + 4f));
        btn4.addActionListener(e -> priStiskuBtnCislice(e));
        contentPane.add(btn4, "cell 2 4");

        //---- btn5 ----
        btn5.setText("5");
        btn5.setForeground(Color.blue);
        btn5.setFont(btn5.getFont().deriveFont(btn5.getFont().getSize() + 4f));
        btn5.addActionListener(e -> priStiskuBtnCislice(e));
        contentPane.add(btn5, "cell 3 4");

        //---- btn6 ----
        btn6.setText("6");
        btn6.setForeground(Color.blue);
        btn6.setFont(btn6.getFont().deriveFont(btn6.getFont().getSize() + 4f));
        btn6.addActionListener(e -> priStiskuBtnCislice(e));
        contentPane.add(btn6, "cell 4 4");

        //---- btnNasobeni ----
        btnNasobeni.setText("*");
        btnNasobeni.setForeground(Color.red);
        btnNasobeni.setFont(btnNasobeni.getFont().deriveFont(btnNasobeni.getFont().getSize() + 4f));
        contentPane.add(btnNasobeni, "cell 5 4");

        //---- btnProcento ----
        btnProcento.setText("%");
        btnProcento.setForeground(Color.red);
        btnProcento.setFont(btnProcento.getFont().deriveFont(btnProcento.getFont().getSize() + 4f));
        contentPane.add(btnProcento, "cell 6 4");

        //---- btnMS ----
        btnMS.setText("MS");
        btnMS.setForeground(Color.red);
        btnMS.setFont(btnMS.getFont().deriveFont(btnMS.getFont().getSize() + 4f));
        contentPane.add(btnMS, "cell 1 5");

        //---- btn1 ----
        btn1.setText("1");
        btn1.setForeground(Color.blue);
        btn1.setFont(btn1.getFont().deriveFont(btn1.getFont().getSize() + 4f));
        btn1.addActionListener(e -> priStiskuBtnCislice(e));
        contentPane.add(btn1, "cell 2 5");

        //---- btn2 ----
        btn2.setText("2");
        btn2.setForeground(Color.blue);
        btn2.setFont(btn2.getFont().deriveFont(btn2.getFont().getSize() + 4f));
        btn2.addActionListener(e -> priStiskuBtnCislice(e));
        contentPane.add(btn2, "cell 3 5");

        //---- btn3 ----
        btn3.setText("3");
        btn3.setForeground(Color.blue);
        btn3.setFont(btn3.getFont().deriveFont(btn3.getFont().getSize() + 4f));
        btn3.addActionListener(e -> priStiskuBtnCislice(e));
        contentPane.add(btn3, "cell 4 5");

        //---- btnMinus ----
        btnMinus.setText("-");
        btnMinus.setForeground(Color.red);
        btnMinus.setFont(btnMinus.getFont().deriveFont(btnMinus.getFont().getSize() + 4f));
        contentPane.add(btnMinus, "cell 5 5");

        //---- btn1lomenoX ----
        btn1lomenoX.setText("1/x");
        btn1lomenoX.setForeground(Color.red);
        btn1lomenoX.setFont(btn1lomenoX.getFont().deriveFont(btn1lomenoX.getFont().getSize() + 4f));
        contentPane.add(btn1lomenoX, "cell 6 5");

        //---- btnMplus ----
        btnMplus.setText("M+");
        btnMplus.setForeground(Color.red);
        btnMplus.setFont(btnMplus.getFont().deriveFont(btnMplus.getFont().getSize() + 4f));
        contentPane.add(btnMplus, "cell 1 6");

        //---- btn0 ----
        btn0.setText("0");
        btn0.setForeground(Color.blue);
        btn0.setFont(btn0.getFont().deriveFont(btn0.getFont().getSize() + 4f));
        btn0.addActionListener(e -> priStiskuBtnCislice(e));
        contentPane.add(btn0, "cell 2 6");

        //---- btnPlusMinus ----
        btnPlusMinus.setText("+/-");
        btnPlusMinus.setForeground(Color.blue);
        btnPlusMinus.setFont(btnPlusMinus.getFont().deriveFont(btnPlusMinus.getFont().getSize() + 4f));
        btnPlusMinus.addActionListener(e -> priStiskuBtnPlusMinus(e));
        contentPane.add(btnPlusMinus, "cell 3 6");

        //---- btnTecka ----
        btnTecka.setText(".");
        btnTecka.setForeground(Color.blue);
        btnTecka.setFont(btnTecka.getFont().deriveFont(btnTecka.getFont().getSize() + 4f));
        btnTecka.addActionListener(e -> priStiskuBtnTecka(e));
        contentPane.add(btnTecka, "cell 4 6");

        //---- btnPlus ----
        btnPlus.setText("+");
        btnPlus.setForeground(Color.red);
        btnPlus.setFont(btnPlus.getFont().deriveFont(btnPlus.getFont().getSize() + 4f));
        contentPane.add(btnPlus, "cell 5 6");

        //---- btnRovnitko ----
        btnRovnitko.setText("=");
        btnRovnitko.setForeground(Color.red);
        btnRovnitko.setFont(btnRovnitko.getFont().deriveFont(btnRovnitko.getFont().getSize() + 4f));
        contentPane.add(btnRovnitko, "cell 6 6");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
